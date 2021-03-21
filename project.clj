(defproject artist-pairs "0.1.0-SNAPSHOT"
  :main artist-pairs.core
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.clojure/data.csv "1.0.0"]]
  :repl-options {:init-ns artist-pairs.core}
  :profiles {:dev {:plugins [[com.jakemccrary/lein-test-refresh "0.24.1"]]}})
