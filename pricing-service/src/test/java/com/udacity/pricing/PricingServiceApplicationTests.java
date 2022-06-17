package com.udacity.pricing;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PricingServiceApplicationTests {

	@Autowired
	private MockMvc mvc;

	/**
	 * Creates pre-requisites for testing, such as an example car.
	 */
	@Before
	public void setup() {
	}

	@Test
	public void getPriceByIdShouldSucceed() throws Exception {
		mvc.perform(get("/prices/1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("currency").value("EUR"))
				.andExpect(jsonPath("price").value(12645.23));
	}


}
