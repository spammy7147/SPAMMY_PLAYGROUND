package com.seven.jong.repository.user;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import org.junit.Before;

import com.seven.jong.controller.HomeController;

public class HomeTest {

	HomeController homeController;

	  

	  @Before
	  public void setup() {
	    MockitoAnnotations.initMocks(this);

	    homeController = new HomeController();
	  }

	  @Test
	  public void testMockMvC() throws Exception {
	    MockMvc mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();

	    mockMvc.perform(MockMvcRequestBuilders.get("/"))
	      .andExpect(MockMvcResultMatchers.status().isOk())
	      .andExpect(MockMvcResultMatchers.view().name("home"));
	  }

	  @Test
	  public void test() {

	  }
}
