(defsystem "paperless-rest"
  :class :package-inferred-system
  :author "Skyler Mayfield"
  :version "0.0.1"
  :description "REST backend for the Paperless document management system."
  :depends-on ("paperless-rest/main" #:clack #:optima))
