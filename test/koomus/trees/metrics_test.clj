(ns koomus.trees.metrics-test
  (:require [clojure.test :refer :all]
            [com.stuartsierra.component :as component]
            [metrics.core :refer [new-registry]]
            [koomus.trees.metrics :as metrics]
            ))

(deftest test-generate-reporter
  (let [host "127.0.0.1" reg (new-registry)]
    (#'metrics/generate-reporter reg host)
    (println reg)
    (is true)))
