package com.oreilly.boot;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

	private MockMvc mvc;

	@Before
	public void setUp(){
	  mvc = MockMvcBuilders.standaloneSetup(new Application()).build();
	}
	
	@Test
	public void ouch() throws Exception{
	  
	}

}