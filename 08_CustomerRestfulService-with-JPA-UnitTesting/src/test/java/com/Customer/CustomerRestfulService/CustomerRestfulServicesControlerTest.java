package com.Customer.CustomerRestfulService;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.Customer.CustomerRestfulService.pojo.Customer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CustomerRestfulServicesControlerTest {
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Test
	public void testGetEmployeeById() throws IOException {
		ResponseEntity<String> responseEntity=testRestTemplate.getForEntity("/getById/1",String.class);
		//System.out.println(responseEntity);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(responseEntity.getBody());
		JsonNode name = root.path("name");
		//System.out.println(name);
		assertEquals("\"Subhamoy\"", name.toString());
	}
	
	
	@Test
	public void testGetEmployeeByIdThatDoesntExist() throws IOException {
		ResponseEntity<String> responseEntity=testRestTemplate.getForEntity("/getById/99",String.class);
		//System.out.println(responseEntity);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = (mapper.readTree(responseEntity.getBody())).path("statusCodeValue");
		//JsonNode name = root.path("");
		//System.out.println(root);
		assertEquals(404, root.asInt());
	}
	
	@Test
	public void testAddEmployee() throws IOException {
//		ResponseEntity<String> responseEntity=testRestTemplate.getForEntity("/getById/99",String.class);
//		System.out.println(responseEntity);
//		ObjectMapper mapper = new ObjectMapper();
//		JsonNode root = (mapper.readTree(responseEntity.getBody())).path("statusCodeValue");
//		//JsonNode name = root.path("");
//		System.out.println(root);
//		assertEquals(404, root.asInt());
		
		
		HttpEntity<Customer> request = new HttpEntity<>(new Customer(	"Test","Test"));
		Customer customer= testRestTemplate.postForObject("/add", request, Customer.class);
		assertThat(customer, notNullValue());
		assertThat(customer.getName(), is("Test"));
		System.out.println(customer);
		
	}
	
}
