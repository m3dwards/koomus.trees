(defproject koomus.trees "0.1.0-SNAPSHOT"
  :description "A component for easily adding metrics to app"
  :url "https://github.com/maxwe789/koomus.trees"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [com.stuartsierra/component "0.2.2"]
                 [ring/ring-jetty-adapter "1.3.1"]
                 [environ "1.0.0"]
                 [metrics-clojure "2.3.0"]
                 [metrics-clojure-jvm "2.3.0"]
                 [metrics-clojure-graphite "2.3.0"]]
  :aliases {"test-all" ["do" ["test"] ["with-profile" "+1.6" "test"]]}
  :profiles {:dev {:env {:graphite-host "127.0.0.1"}
                   :plugins [[lein-midje "3.1.3" ]
                             [lein-environ "1.0.0"]]
                   :dependencies [[midje "1.6.3"]
                                  [org.clojure/tools.namespace "0.2.7"]]}})
