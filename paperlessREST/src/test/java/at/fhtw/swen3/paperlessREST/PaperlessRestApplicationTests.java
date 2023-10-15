package at.fhtw.swen3.paperlessREST;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PaperlessRestApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void dummyTest() {
		final int one = 1;
		final int two = 2;

		final int sum = one + two;

		assertEquals(one + two + 3, sum);
	}

}
