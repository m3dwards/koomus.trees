(ns koomus.trees.metrics-test
  (:require [clojure.test :refer :all]
            [midje.sweet :refer :all]
            [com.stuartsierra.component :as component]
            [metrics.core :refer [new-registry]]
            [koomus.trees.metrics :as metrics]
            [clojure.reflect :refer [reflect]]
            [clojure.pprint :refer [pprint]]
            [metrics.reporters.graphite :as graphite])
  (:import [java.util.concurrent TimeUnit]
           [com.codahale.metrics MetricFilter]))

(def generate-reporter #'metrics/generate-reporter)
(def init-reporter #'metrics/init-reporter)

;;notice this typed param! try removing the type and see the test pass
(defn typed-params
  [^long something]
  (+ something something)
  )

(defn run-this
  [something]
  (typed-params something)
  )

(facts "Metrics tests"
  
  (fact "generate-reporter should return a new graphite reporter" 
    (generate-reporter  ..reg.. {:host ..host..
                                 :port ..port..
                                 :prefix ..prefix..}) => irrelevant
    (provided 
      (graphite/reporter 
        ..reg.. {:host ..host..
                 :port ..port..
                 :prefix ..prefix..
                 :rate-unit TimeUnit/SECONDS
                 :duration-unit TimeUnit/MILLISECONDS
                 :filter MetricFilter/ALL})  => irrelevant))
 
  ;;(fact "init reporter should start the report"
  ;;  (init-reporter anything) => irrelevant
  ;;  (provided 
  ;;    (graphite/start anything anything) => irrelevant
  ;;    (generate-reporter anything anything) => irrelevant
  ;;    (graphite/reporter anything anything) => irrelevant
  ;;    ))

  ;;This works
  (fact "test thing"
    (metrics/test-thing anything) => irrelevant
    (provided 
      (graphite/reporter anything anything) => irrelevant
      )) 
  
  ;;This does not work but it looks exactly like the above
  ;;(fact "other test thing"
  ;;  (metrics/test-other-thing anything) => irrelevant
  ;;  (provided 
  ;;    (graphite/start anything anything)
  ;;    ))

  (fact "test thing that might work"
    (run-this 10) => irrelevant
    (provided 
      (typed-params 10) => irrelevant
      )) 


)

