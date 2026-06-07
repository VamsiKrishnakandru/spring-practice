package com.tron.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.tron.model.Student;
import com.tron.service.IGreetingService;

import tools.jackson.databind.ObjectMapper;

@WebMvcTest(GreetingController.class)
public class GreetingControllerTest 
{
	@MockitoBean
	private IGreetingService service;
	
	@Autowired 
	private MockMvc mockMvc;
	
	@Test
	void testGetWish() throws Exception
	{
		//Mocking
		Mockito.when(service.generateGreeting()).thenReturn("Good Morning");
		
		//RequestObject
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/greet");
		ResultActions res = mockMvc.perform(requestBuilder);
		MvcResult mvcResult = res.andReturn();
		
		MockHttpServletResponse response = mvcResult.getResponse();
		int statusCode=response.getStatus();
		
		//Assertion
		assertEquals(200, statusCode);
	}
	
	@Test
	void testaddStudentInfo() throws Exception
	{
		//mocking
		Mockito.when(service.addStudent(ArgumentMatchers.any())).thenReturn(true);
		
		Student st=new Student(1, "Tron", "Hyderbad", 23);
		ObjectMapper mapper = new ObjectMapper();
		String json=mapper.writeValueAsString(st);
		
		//request
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/add-stu")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json);
		ResultActions res = mockMvc.perform(requestBuilder);
		MvcResult mvcResult = res.andReturn();
		
		MockHttpServletResponse response = mvcResult.getResponse();
		int statusCode=response.getStatus();
		
		//assertion
		assertEquals(201, statusCode);
	}
}
