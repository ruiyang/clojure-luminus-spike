# clojure-luminus-spike
A spike project for luminus

1. added ring-json to return json response
2. added support for postgresql
3. ragtime to do migration
4. yaml file and korma to load fixture in repl

## Prerequisites

You will need [Leiningen][1] 2.0 or above installed.

[1]: https://github.com/technomancy/leiningen

## Running

To start a web server for the application, run:

    lein ring server
Or
    > lein repl
    > (start-server "3000")

## License

Copyright © 2014 ryang.sei@gmail.com
