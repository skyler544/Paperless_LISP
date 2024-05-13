(defpackage #:paperless-rest/storage
  (:use #:cl #:cl-s3)
  (:export #:store-file))
(in-package #:paperless-rest/storage)

(defun set-credentials ()
  (setf cl-s3::*amazon-host* "minio:9000")
  (setf *access-key-id* "paperless_minio")
  (setf *secret-access-key* "paperless"))

(defun store-file (filename filetype file-as-string)
  (let ((bucket "documents"))
    (set-credentials)
    (ignore-errors (put-bucket bucket))

    (format t "~%Uploading ~S to http://~S/~S~%Credentials: ~S ~S~%"
            filename cl-s3::*amazon-host* bucket *access-key-id* *secret-access-key*)

    (put-object bucket filename file-as-string "application/octet-stream" ;; filetype
                )))
