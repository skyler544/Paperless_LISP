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
	$(MVN) package -DskipTests

test:
	$(MVN) test

compile:
	$(MVN) compile

clean:
	$(MVN) clean
