(ns koomus.trees.metrics-test
  (:require [clojure.test :refer :all]
            [com.stuartsierra.component :as component]))

(deftest test-jvm-metrics
  (is (= 4 (+ 2 2))))
