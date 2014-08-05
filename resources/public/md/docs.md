
## Endpoints

### GET /cutebomb ([link](http://localhost:3000/cutebomb))

Redirects to a random cute animal picture.

### GET /cutebomb-url ([link](http://localhost:3000/cutebomb-url))

Gets the url to a random cute animal picture.

    curl http://localhost:3000/cutebomb-url
    {"cute-bomb":"http:\/\/i.imgur.com\/2Wqq0nV.jpg"}

### POST /bomb

#### Payload: Json containing target user and sender id

TODO!

Ex: `{"user": "foobar", "sender": "bazman123"}`
