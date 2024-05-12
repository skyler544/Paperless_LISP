(defpackage #:paperless-rest/main
  (:nicknames #:paperless-rest/main)
  (:use #:cl)
  (:import-from #:paperless-rest/controller #:router)
  (:import-from #:clack #:clackup)
  (:import-from #:lack #:builder)
  (:export #:default-server))
(in-package #:paperless-rest/main)


(defvar *app*
  (builder
   :accesslog
   :backtrace
   (lambda (env)
     (funcall 'router env)))
  "Container for the application entrypoint.")


(defun default-server ()
  "Start the application."
  (clackup *app* :port 8080))

;; Return the application entrypoint; this allows the application to be started
;; from outside via the clackup shell command.
*app*
