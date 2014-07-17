(defproject org.clojars.binaryalchemist/clj-daemon "1.0.0"
  :description "Library for daemonization based on daemon recipe found here: http://www.rkn.io/2014/02/06/clojure-cookbook-daemons/"
  :url "https://github.com/binaryalchemist/clj-daemon"
  :license {:name "MIT License"
            :url "http://www.opensource.org/licenses/mit-license.php"}
  :dependencies [[org.clojure/clojure "1.5.1"] [org.apache.commons/commons-daemon "1.0.9"]]
  :aot :all)
