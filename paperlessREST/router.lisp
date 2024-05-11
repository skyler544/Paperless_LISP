(defpackage #:paperless-rest/router
  (:use #:cl #:optima)
  (:import-from #:paperless-rest/models
                #:ui-settings)
  (:export #:handle))
(in-package #:paperless-rest/router)

(defun handle (env)
  ;; OPTIMA:MATCH works somewhat like a switch statement but with arbitrary
  ;; pattern types
  (match env
    ((guard (property :path-info path)
            (alexandria:starts-with-subseq "/api/ui_settings/" path))
     `(200 (:content-type "application/json") (,(ui-settings))))
    ((guard (property :path-info path)
            (alexandria:starts-with-subseq "/api/" path))
     `(200 (:content-type "application/json") (,(format nil "{}"))))
    ((guard (property :path-info path)
            (alexandria:starts-with-subseq "/actuator/health" path))
     `(200 nil (,(format nil "Server is alive, thanks for checking."))))
    ((property :path-info path)
     `(200 nil (,(format nil "Path ~A not supported, thanks anyway." path))))))
