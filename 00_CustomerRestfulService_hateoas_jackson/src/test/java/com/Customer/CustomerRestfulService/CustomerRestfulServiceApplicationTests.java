package com.Customer.CustomerRestfulService;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.Customer.CustomerRestfulService.controller.CustomerController;
import com.Customer.CustomerRestfulService.pojo.Customer;
import com.Customer.CustomerRestfulService.service.CustomerService;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
@SpringBootTest(classes = CustomerRestfulServiceApplication.class)
@ContextConfiguration(classes=CustomerRestfulServiceApplication.class)
//@ComponentScan(value="com")
public class CustomerRestfulServiceApplicationTests {

	@Autowired
    private MockMvc mockMvc;
 
    @MockBean
    private CustomerService service;
    
    @Test
    public void givenEmployees_whenGetEmployees_thenReturnJsonArray()
      throws Exception {
         
        Customer alex = new Customer(5,"alex","usa");
     
        ArrayList<Customer> allEmployees = (ArrayList<Customer>) Arrays.asList(alex);
     
     /*   when(service.viewAl()).willReturn(allEmployees);
     
        mvc.perform(get("/api/employees")
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andExpect(jsonPath("$", hasSize(1)))
          .andExpect(jsonPath("$[0].name", is(alex.getName())));*/
        Mockito.when(
				service.viewAl()).thenReturn(allEmployees);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/viewall").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		
//		  mockMvc.perform(get("/api/employees")
//		          .contentType(MediaType.APPLICATION_JSON))
//		          .andExpect(status().isOk())
//		          .andExpect(jsonPath("$", hasSize(1)))
//		          .andExpect(jsonPath("$[0].name", is(alex.getName())));
//		
		
		
		/*String expected = "{id:Course1,name:Spring,description:10 Steps}";

		// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);*/
	}
    

}
