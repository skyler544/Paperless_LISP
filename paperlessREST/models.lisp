(defpackage #:paperless-rest/models
  (:use #:cl)
  (:import-from #:com.inuoe.jzon
                #:stringify)
  (:export #:ui-settings)
  (:documentation "This file contains the data models for the Paperless application. Most are
hardcoded for now, but extending them should be as simple as adding the
appropriate arguments to the exported functions. The functions that return the
models themselves return them as string representations of JSON, but adding a
second return value would allow callers to also manipulate the hash tables
themselves."))
(in-package #:paperless-rest/models)

;; Most of the functions are not exported, and consist of machinery for
;; manipulating Lisp's hash tables with a more comfortable syntax. TODO consider
;; whether it's worth making a hash table library for use elsewhere in the
;; application.

(defun set-hash (key value table)
  "Associate KEY with VALUE in TABLE."
  (setf (gethash key table) value))

(defun build-table (pairs)
  "Returns a hash table containing the contents of PAIRS. PAIRS looks like ((KEY
VALUE)*)."
  (let ((hash-table (make-hash-table)))
    (mapcar (lambda (pair)
              (set-hash
               (first pair)
               (second pair)
               hash-table))
            pairs)
    hash-table))


(defun user ()
  (build-table '((id 0)
                 (username test-user)
                 (is_superuser t)
                 (groups '()))))

(defun update-checking ()
  (build-table '((backend_settings none))))

(defun settings ()
  (build-table `((update_checking ,(update-checking)))))

(defun ui-settings ()
  (stringify (build-table `((display_name test-user)
                            (user ,(user))
                            (settings ,(settings))
                            (permissions ())))))
