(defpackage #:paperless-rest/controller
  (:use #:cl #:optima)
  (:import-from #:paperless-rest/models
                #:ui-settings
                #:statistics
                #:saved-views)
  (:import-from #:paperless-rest/dao
                #:document
                #:create-document)
  (:import-from #:paperless-rest/requests
                #:request-body)
  (:import-from #:alexandria
                #:starts-with-subseq)
  (:export #:router))
(in-package #:paperless-rest/controller)

(defun router (env)
  ;; OPTIMA:MATCH works somewhat like a switch statement but with arbitrary
  ;; pattern types
  (match env
    ((guard (property :path-info path)
            (starts-with-subseq "/api/documents/post_document/" path))
     (let* ((body (request-body env))
            (document-props (assoc "document" body :test 'equal))
            (title (third document-props))
            (document_type (fourth document-props)))
       (format t "~%Received document: ~A ~A" title document_type)
       (create-document (make-instance 'document :title title :document_type document_type))
       ;; TODO
       ;; send message via message queue
       ;; send file to cold storage
       `(200 nil ())))
    ((guard (property :path-info path)
            (starts-with-subseq "/api/ui_settings/" path))
     `(200 (:content-type "application/json") (,(ui-settings))))
    ((guard (property :path-info path)
            (starts-with-subseq "/api/statistics/" path))
     `(200 (:content-type "application/json") (,(statistics))))
    ((guard (property :path-info path)
            (starts-with-subseq "/api/saved_views/" path))
     `(200 (:content-type "application/json") (,(saved-views))))
    ((guard (property :path-info path)
            (starts-with-subseq "/api/" path))
     `(200 (:content-type "application/json") ()))
    ((guard (property :path-info path)
            (starts-with-subseq "/actuator/health" path))
     `(200 nil (,(format nil "Server is alive, thanks for checking."))))
    ((property :path-info path)
     `(200 nil (,(format nil "Path ~A not supported, thanks anyway." path))))))
