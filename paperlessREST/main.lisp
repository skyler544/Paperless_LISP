(defpackage #:paperless-rest/main
  (:nicknames #:paperless-rest/main)
  (:use #:cl)
  (:import-from #:paperless-rest/router #:handle)
  (:import-from #:clack #:clackup)
  (:export #:default-server))
(in-package #:paperless-rest/main)

(defvar *app*
  (lambda (env)
    (funcall 'handle env)))

(defun default-server ()
  (clackup *app* :port 8080))

*app*
