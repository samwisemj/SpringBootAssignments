package com.Employee.EmployeeView.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.Employee.EmployeeView.pojo.Customer;

@Controller
public class CustomerController {
	@RequestMapping(value = "/viewCustomers")
	public String getAllCustomer(Model model) throws IOException {
		RestTemplate restTemplate = new RestTemplate();
		Collection<Map> responseEntity = (ArrayList<Map>) restTemplate.getForObject("http://localhost:8080/viewAll",Collection.class);
		System.out.println(responseEntity);
		ArrayList<Customer> allCustomer = new ArrayList<>();
		for (Map map : responseEntity) {
			allCustomer.add(new Customer(Integer.parseInt(map.get("id").toString()), map.get("name").toString(),
					map.get("address").toString()));
		}

		model.addAttribute("allCustomer",allCustomer);
		return "viewAll";
	}

	@RequestMapping(value = "/getById/{id}")
	public String getAllCustomer(@PathVariable(value = "id") int id, Model model) throws IOException {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Customer> responseEntity = restTemplate.getForEntity("http://localhost:8080/getById/" + id,
				Customer.class);
		System.out.println(responseEntity.getBody());

		Customer c = new Customer(responseEntity.getBody().getId(), responseEntity.getBody().getName(),
				responseEntity.getBody().getAddress());
		ArrayList<Customer> list = new ArrayList<>();
		list.add(c);
		model.addAttribute("allCustomer", list);

		return "viewAll";

	}

	/*
	 * //System.out.println(responseEntity.getBody()); // ArrayList list = new
	 * ArrayList(responseEntity.getBody()); // System.out.println(list); //
	 * ArrayList<Customer> allCustomer = new ArrayList<>(); // // for (int i = 0; i
	 * < list.size(); i++) { // System.out.println(list.get(i)); // }
	 * 
	 * // ArrayList<Customer> allCustomer=new ArrayList<>();
	 * 
	 * // ObjectMapper mapper = new ObjectMapper();
	 * 
	 * // for(String string:list) // { // ObjectMapper mapper = new ObjectMapper();
	 * // JsonNode root = mapper.readTree(string); // //JsonNode name =
	 * root.path("name"); // allCustomer.add( new
	 * Customer(root.path("id").asInt(),root.path("name").asText(),root.path(
	 * "address").asText())); // } // //System.out.println(list);
	 * //model.addAttribute("allCustomer",allCustomer);
	 */

}
