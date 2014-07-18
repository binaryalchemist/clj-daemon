(ns clj-daemon.start-stop-init-example
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
