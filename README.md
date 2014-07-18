# clj-daemon

A simple daemonization library for clojure daemons. It was inpsired by Ryan Nuefeld's recipe described here:  http://www.rkn.io/2014/02/06/clojure-cookbook-daemons/ 

## Usage
Add dependency coordinates in your project.clj.
[![Clojars Project](http://clojars.org/org.clojars.binaryalchemist/clj-daemon/latest-version.svg)](http://clojars.org/org.clojars.binaryalchemist/clj-daemon)

The following is an example of defining start, stop, and init service handlers.

```Clojure
(ns clj-daemon.start-stop-init
  (:require [clj-daemon.core :refer :all]))

(def state (atom {}))

(defn test-init [args]
  (swap! state assoc :running true))

(defn test-start []
  (while (:running @state)
    (println "tick")
    (Thread/sleep 2000)))

(defn test-stop []
  (swap! state assoc :running false))

(clj-daemon.core/daemonize test-init test-start test-stop)
(clj-daemon.core/-main) ;this could also be done through the project.clj
```

## License

The MIT License (MIT)

Copyright (c) 2014 Kristopher Alexander

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
