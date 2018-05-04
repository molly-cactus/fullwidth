#!/usr/bin/env clj

(defn widen-char
  "Returns the fullwidth version of a character.
  If no fullwidth version exists, returns the character."
  [c]
  (let [code (int c)]
    (char
      (if (> 127 code 32) ; character w/ fullwidth equivalent
        (+ 65248 code)
        c))))

(defn fullwidth [cs]
  (apply str (map widen-char cs)))

(print (fullwidth (clojure.string/join " " *command-line-args*)))
