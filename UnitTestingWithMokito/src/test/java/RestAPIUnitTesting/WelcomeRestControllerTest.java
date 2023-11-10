package RestAPIUnitTesting;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import RestAPIUnitTesting.Rest.WelcomeRestController;
import RestAPIUnitTesting.Service.WelcomeService;

@WebMvcTest(value = WelcomeRestController.class)  // this is because we are performing unit test in controller
class WelcomeRestControllerTest {

	//@Autowired // real object will be injected which we should not instead use mock
	@MockBean  // now muck obj will be inject
	private WelcomeService welcomeService;  // this is depended object of controller we are autowiring service layer because of controller target object
	
	@Autowired
	private MockMvc mockMvc;
	@Test
	public void testWelcome() throws Exception {
		when(welcomeService.getWelcomeMsg()).thenReturn("Good Morning");
		// here we have get because we are getting the record. if post do post, delete do delete,  put do put
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/welcome"); // if url pattern "/welcome?" 
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		int status = response.getStatus();
		assertEquals(200, status);
		
	}
	
	// we can create different class as well if required but i have create in one.
	@Test
	public void greeting() throws Exception {
		when(welcomeService.getGreetMsg()).thenReturn("Hello how are you?");
		
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/greet");
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		int status = response.getStatus();
		assertEquals(200, status);
		
	}
	
}
