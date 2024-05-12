(defpackage #:paperless-rest/models
  (:use #:cl)
  (:import-from #:com.inuoe.jzon
                #:stringify)
  (:export #:ui-settings)
  (:export #:statistics)
  (:export #:saved-views)
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

;; Hash table utilities
;; ----------------------------------------------------
(defun set-hash (key value table)
  "Associate KEY with VALUE in TABLE."
  (setf (gethash key table) value))

(defun build-table (pairs)
  "Returns a hash table containing the contents of PAIRS. PAIRS looks like ((KEY
VALUE)*)."
  (let ((hash-table (make-hash-table)))
    (mapcar (lambda (pair)
              (set-hash (first pair) (second pair) hash-table))
            pairs)
    hash-table))


;; UI Settings
;; ----------------------------------------------------
(defun ui-settings ()
  (stringify (build-table '((display_name test-user)
                            (user null)
                            (settings null)
                            (permissions #())))))

;; Statistics
;; ----------------------------------------------------
(defun statistics ()
  (stringify (build-table
              '((documents_total null)
                (documents_inbox null)
                (inbox_tag null)
                (character_count null)
                (document_file_type_counts #())))))

;; Saved Views
;; ----------------------------------------------------
(defun saved-views ()
  (stringify (build-table
              '((count null)
                (next null)
                (previous null)
                (all #())
                (results #())))))
