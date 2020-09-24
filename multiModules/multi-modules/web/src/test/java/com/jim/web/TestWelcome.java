package com.jim.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.jim.web.config.SpringConfig;

@SpringJUnitWebConfig(SpringConfig.class)
@DisplayName("Test Spring default View")
public class TestWelcome {
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@BeforeEach
	void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void testDefault() throws Exception {
		this.mockMvc.perform(
				get("/"))
					.andExpect(status().isOk())
					.andExpect(view().name("index"))
					.andExpect(model().attribute("query", "123456"));
       //.andExpect(model().attribute("sha256", "8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92"))
       //.andExpect(model().attribute("md5", "e10adc3949ba59abbe56e057f20f883e"));
	}

}
