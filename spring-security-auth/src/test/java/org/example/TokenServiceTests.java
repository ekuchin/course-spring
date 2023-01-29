package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.example.service.TokenService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest(classes = TestConfig.class)
@AutoConfigureMockMvc
class TokenServiceTests {

	@Autowired TokenService tokenService;

	@Autowired private MockMvc mvc;

	@DisplayName("Token length greater then 0")
	@WithUserDetails("tester")
	@Test
	public void isTokenGenerated() {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		String result = tokenService.generateToken(auth);
		System.out.println(result);
		assertTrue(result.length()>0);
	}

	@Test
	@WithUserDetails("tester")
	public void testAuthController() throws Exception {
		mvc.perform(MockMvcRequestBuilders
				.post("/auth")
				//.contentType(MediaType.APPLICATION_JSON)
				)
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
