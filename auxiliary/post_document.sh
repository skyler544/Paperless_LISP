# Note that the @ sigil is needed for curl to transfer a file with -F.
# See the OPTIONS section of man curl for details.
curl -v \
  'http://localhost/api/documents/post_document/' \
  -H 'accept: */*' \
  -H 'Content-Type: multipart/form-data' \
  -F 'title=Hello World' \
  -F 'document=@docs/HelloWorld.pdf'
