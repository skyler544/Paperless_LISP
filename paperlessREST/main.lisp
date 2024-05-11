(defpackage #:paperless-rest/main
  (:nicknames #:paperless-rest/main)
  (:use #:cl)
  (:import-from #:paperless-rest/router #:handle))
(in-package #:paperless-rest/main)

(lambda (env)
  (funcall 'handle env))
