(defpackage #:paperless-rest/requests
  (:use #:cl)
  (:import-from #:http-body
                #:parse)
  (:import-from #:circular-streams
                #:circular-input-stream
                #:make-circular-input-stream)
  (:export #:request-body))
(in-package #:paperless-rest/requests)

(defun request-body (env)
  (destructuring-bind (&key content-length content-type raw-body &allow-other-keys) env
    (setf raw-body (make-circular-input-stream raw-body))
    (parse content-type content-length raw-body)))
