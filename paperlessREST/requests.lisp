(defpackage #:paperless-rest/requests
  (:use #:cl)
  (:import-from #:http-body
                #:parse)
  (:import-from #:circular-streams
                #:circular-input-stream
                #:make-circular-input-stream)
  (:export #:make-request
           #:request-body))
(in-package #:paperless-rest/requests)

;; HACK much of the content of this file was taken from lack; for whatever
;; reason the public interface of lack does not allow you to retrieve things
;; like the name of the uploaded file from the request body, even though this
;; functionality does exist within lack itself. It's possible that this was
;; simply never finished.

(defun request-body (env)
  (request-body-parameters (make-request env)))


;; REQUEST STRUCTURE AND CONSTRUCTOR FROM LACK
;; ----------------------------------------------------
(defstruct (request (:constructor %make-request))
  (env nil :type list)

  (method nil :type (or null keyword))
  (script-name nil :type (or null string))
  (path-info nil :type (or null string))
  (server-name nil :type (or null string))
  (server-port nil :type (or null integer))
  (server-protocol nil :type (or null keyword))
  (uri nil :type (or null string))
  (uri-scheme nil :type (or null string keyword))
  (remote-addr nil :type (or null string))
  (remote-port nil :type (or null keyword integer))
  (query-string nil :type (or null string))
  (raw-body nil :type (or null stream))
  (content-length nil :type (or null integer))
  (content-type nil :type (or null string))
  (headers nil :type (or null hash-table))

  (cookies nil :type list)
  (body-parameters nil :type list)
  (query-parameters nil :type list)
  (accept nil :type list))

(declaim (inline request-has-body-p))
(defun request-has-body-p (req)
  (or (request-content-length req)
      (string= (gethash "transfer-encoding" (request-headers req)) "chunked")))

(defun make-request (env)
  (let ((req (apply #'%make-request :env env :allow-other-keys t env)))
    (with-slots (method uri uri-scheme) req
      (unless method
        (setf method (getf env :request-method)))
      (unless uri
        (setf uri (getf env :request-uri)))
      (unless uri-scheme
        ;; for some reason, it is called url-scheme in the environment plist :(
        (setf uri-scheme (getf env :url-scheme))))

    (with-slots (body-parameters raw-body content-length content-type) req
      (when raw-body
        (unless (typep raw-body 'circular-input-stream)
          (setf raw-body (make-circular-input-stream raw-body)))

        ;; POST parameters
        (when (and (null body-parameters)
                   (request-has-body-p req)
                   (stringp content-type))
          (let ((parsed (http-body:parse content-type content-length raw-body)))
            (when (and (consp parsed)
                       (every #'consp parsed))
              (setf body-parameters parsed)))
          (file-position raw-body 0)
          (setf (getf env :raw-body) raw-body)
          (rplacd (last env) (list :body-parameters body-parameters)))))

    (setf (request-env req) env)

    req))
;; (defun make-request (env)
;;   (let ((req (apply #'%make-request :env env :allow-other-keys t env)))
;;     (with-slots (method uri uri-scheme) req
;;       (unless method
;;         (setf method (getf env :request-method)))
;;       (unless uri
;;         (setf uri (getf env :request-uri)))
;;       (unless uri-scheme
;;         ;; for some reason, it is called url-scheme in the environment plist :(
;;         (setf uri-scheme (getf env :url-scheme))))

;;     (with-slots (body-parameters raw-body content-length content-type) req
;;       (when raw-body
;;         (unless (typep raw-body 'circular-input-stream)
;;           (setf raw-body (make-circular-input-stream raw-body)))

;;         ;; POST parameters
;;         (when (and (null body-parameters)
;;                    (request-has-body-p req)
;;                    (stringp content-type))
;;           (let ((parsed (http-body:parse content-type content-length raw-body)))
;;             (when (and (consp parsed)
;;                        (every #'consp parsed))
;;               (setf body-parameters parsed)))
;;           (file-position raw-body 0)
;;           (setf (getf env :raw-body) raw-body)
;;           (rplacd (last env) (list :body-parameters body-parameters)))))

;;     (setf (request-env req) env)

;;     req))
