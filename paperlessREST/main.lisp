(defpackage #:paperless-rest
  (:nicknames #:paperless-rest/main)
  (:use #:cl #:clack #:optima))
(in-package #:paperless-rest)

(defun handler (env)
  (destructuring-bind (&key content-type raw-body &allow-other-keys) env
    `(200
      nil
      ,(format t "Content Type: ~A~%Body: ~A~%" content-type raw-body))))

(defvar *app*
  (lambda (env)
    (funcall 'handler env)))

(defparameter *server* (clackup *app* :server :woo :port 8080))
