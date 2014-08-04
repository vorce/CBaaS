
## Endpoints

### GET /cutebomb ([link](http://localhost:3000/cutebomb))

Redirects to a random cute animal picture.

### GET /cutebomb-url ([link](http://localhost:3000/cutebomb-url))

Gets the url to a random cute animal picture.

    curl http://localhost:3000/cutebomb-url
    {"cute-bomb":"http:\/\/i.imgur.com\/2Wqq0nV.jpg"}

### GET /cutebomb/{keywords}

TODO

Get a random cute animal picture in that is tagged with at least one of the provided keywords

Ex: /cutebomb/otter,turtle
