package com.CustomerView.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.CustomerView.pojo.Customer;

@Controller
public class CustomerController {
	@RequestMapping(value = "/viewAll")
	public String getAllCustomer(Model model) throws IOException {
		RestTemplate restTemplate = new RestTemplate();
		Collection<Map> responseEntity = (ArrayList<Map>) restTemplate.getForObject("http://localhost:8080/viewAll",
				Collection.class);
		System.out.println(responseEntity);
		ArrayList<Customer> allCustomer = new ArrayList<>();
		for (Map map : responseEntity) {
			allCustomer.add(new Customer(Integer.parseInt(map.get("id").toString()), map.get("name").toString(),
					map.get("address").toString()));
		}

		model.addAttribute("allCustomer", allCustomer);
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

	@RequestMapping(value = "/add")
	public String addNewCustomer() {

		return "addNewCustomer";
	}
	
	@RequestMapping(value = "/delete")
	public String deleteCustomer() {

		return "deleteCustomer";
	}

	@RequestMapping(value = "/update")
	public String updateACustomer() throws IOException {

		return "updateCustomer";
	}

	@RequestMapping(value = "/addNewCustomer", method = RequestMethod.POST)
	public String addCustomer(@RequestParam String id, String name, String address, Model model) throws IOException {
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("id", id);
		map.add("name", name);
		map.add("address", address);

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

		ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8080/add/", request,
				String.class);

		System.out.println(response);

		return "redirect:viewAll";

	}

	@RequestMapping(value = "/updateCustomer", method = RequestMethod.POST)
	public String updateCustomer(@RequestParam String id, String name, String address, Model model) throws IOException {
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("id", id);
		map.add("name", name);
		map.add("address", address);

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

		ResponseEntity<String> response = restTemplate.exchange("http://localhost:8080/update", HttpMethod.PUT, request,String.class);
		return "redirect:viewAll";

	}

	@RequestMapping(value = "/deleteCustomer", method = RequestMethod.POST)
	public String updateCustomer(@RequestParam String id,Model model) throws IOException {
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
System.out.println(id);
	 restTemplate.delete("http://localhost:8080/delete?id="+id,String.class);
		return "redirect:viewAll";

	}
	
	
}

