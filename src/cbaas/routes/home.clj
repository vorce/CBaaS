(ns cbaas.routes.home
  (:require [compojure.core :refer :all]
            [cbaas.layout :as layout]
            [cbaas.util :as util]
            [clj-http.client :as client]
            [clojure.data.json :as json]
            [noir.response :as response]))

(defn home-page []
  (layout/render
    "home.html" {:content (util/md->html "/md/docs.md")}))

(defn about-page []
  (layout/render "about.html"))

(def source-url "https://api.imgur.com/3/gallery/r/aww/time/1")
(def client-id "002a810c8b8d55c")
(def imgur-score-limit 100000)

(defn highrank? [x]
  (-> (get x "score")
      (>= imgur-score-limit)))

(defn cute-bomb []
  (-> (filter highrank?
    (-> (client/get source-url
                  {:headers {"Authorization" (str "Client-ID " client-id)}})
      (:body)
      (json/read-str)
      (get "data")))
    (rand-nth)
    (get "link")))

(defroutes home-routes
  (GET "/" [] (home-page))
  (GET "/cutebomb" [] (response/redirect (cute-bomb)))
  (GET "/cutebomb-url" [] (json {:cute-bomb (cute-bomb)}))
  (GET "/about" [] (about-page)))
