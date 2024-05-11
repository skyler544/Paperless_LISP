# Dependency management
FROM fukamachi/qlot as qlot

WORKDIR /app
COPY qlfile /app
COPY qlfile.lock /app

RUN set -x; qlot install --no-deps

# Main app image
FROM fukamachi/sbcl:latest-alpine

WORKDIR /app
COPY --from=qlot /app/.qlot /app/.qlot

EXPOSE 8080

ENTRYPOINT ["/app/start-server"]
