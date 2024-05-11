(defpackage #:paperless-rest/models
  (:use #:cl)
  (:import-from #:com.inuoe.jzon
                #:stringify)
  (:export #:ui-settings))
(in-package #:paperless-rest/models)

(defun set-hash (key value table)
  (setf (gethash key table) value))

;; hardcoded object, for now
(defun ui-settings ()
  (let* ((settings (make-hash-table))
         (setter (lambda (key value) (set-hash key value settings))))
    (funcall setter 'display_name 'test-user)
    (stringify settings)))
