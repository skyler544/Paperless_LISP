MVN := ./mvnw
RUN := spring-boot:run

all: run

clean-run:
	$(MVN) clean $(RUN)

run:
	$(MVN) $(RUN)

verify:
	$(MVN) verify

package:
	$(MVN) package

test:
	$(MVN) test

compile:
	$(MVN) compile

clean:
	$(MVN) clean
