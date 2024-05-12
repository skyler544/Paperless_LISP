(defpackage #:paperless-rest/dao
  (:use #:cl #:postmodern)
  (:export #:document
           #:create-document))
(in-package #:paperless-rest/dao)

;; connection parameters are hardcoded, for now
(defparameter *connection* '("paperlessdb" "paperless_postgres" "paperless" "db"))

;; Data Access Object
(defclass document ()
  ((id
    :col-type integer
    :col-identity t
    :reader id)
   (title
    :col-type (or db-null string)
    :initarg :title)
   (document_type
    :col-type (or db-null string)
    :initarg :document_type)
   (created_date
    :col-type date
    :initform (local-time:now))
   (content
    :col-type (or db-null string)
    :initarg :content))
  (:metaclass dao-class)
  (:table-name documents))

;; CRUD operations
;; ----------------------------------------------------
(defun create-document (document)
  (with-connection *connection*
    (unless (list-tables)
      (execute (dao-table-definition 'document)))
    (insert-dao document)))