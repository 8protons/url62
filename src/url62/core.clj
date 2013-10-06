(ns url62.core)

(def alphabet "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ")

(defn- int-to-base62 
  "Converts an integer to a base62 number"
   ([n] (int-to-base62 (rem n 62) (quot n 62) ""))
   ([remainder number accum] 
      (cond
        (zero? number) (str (nth alphabet remainder) accum)
        :else (recur (rem number 62) (quot number 62) (str (nth alphabet remainder) accum)))))

(defn generate-id []
  (int-to-base62 (java.math.BigInteger. (clojure.string/replace (str (java.util.UUID/randomUUID)) "-" "") 16)))
