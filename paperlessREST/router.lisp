(defpackage #:paperless-rest/router
  (:use #:cl)
  (:export #:handle))
(in-package #:paperless-rest/router)

(defun handle (env)
  (destructuring-bind (&key content-type raw-body &allow-other-keys) env
    `(200
      nil
      ,(format t "Content Type: ~A~%Body: ~A~%" content-type raw-body))))
