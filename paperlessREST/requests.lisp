(defpackage #:paperless-rest/requests
  (:use #:cl)
  (:import-from #:http-body
                #:parse)
  (:export #:request-body))
(in-package #:paperless-rest/requests)

(defun request-body (env)
  (destructuring-bind (&key content-length content-type raw-body &allow-other-keys) env
    (parse content-type content-length raw-body)))
