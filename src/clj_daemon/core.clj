(ns clj-daemon.core
  (:import [org.apache.commons.daemon Daemon DaemonContext])
  (:gen-class
    :implements [org.apache.commons.daemon.Daemon]))

(defn daemonize [on-init on-start on-stop & [on-destroy]] 
 (defn init [args]  (on-init args))
 (defn start [] (future (on-start)))
 (defn stop [] (on-stop))
 (defn destroy [] (if-not (nil? on-destroy) on-destroy )))
(defn -init [this ^DaemonContext context] (init (.getArguments context)))
(defn -start [this] (future (start)))
(defn -stop [this] (stop))
(defn -destroy [this] (destroy))
(defn -main [& args]
  (init args)
  (start))
