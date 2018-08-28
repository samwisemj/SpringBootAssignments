package com.Customer.CustomerRestfulService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Customer.CustomerRestfulService.pojo.Customer;
import com.Customer.CustomerRestfulService.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService service;
	public CustomerController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void add(int id, String name, String address) {
		service.add(id, name, address);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public void update(int id, String name, String address) {
		service.update(id, name, address);
	}

	@RequestMapping(value = "/viewAll", method = RequestMethod.GET)
	public Resources<Customer> viewAl() {
		Resources<Customer> resources=new Resources<>(service.viewAl());
		
		return resources;
//		Resource <ArrayList<Customer>> resource;
//		ControllerLinkBuilder link=ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass(), update(int,String,String)))
	
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@RequestParam(value="id")int id) {
		service.delete(id);
		return new ResponseEntity<String>("Deleted entity",new HttpHeaders(),HttpStatus.OK);
	}

	@RequestMapping(value="/getById",method=RequestMethod.GET/*,produces=MediaType.ALL_VALUE*/)
	public Resource<Customer> getById(int id)
	{
		Resource<Customer> resource=null;
		for(Customer customer:service.viewAl())
		{
			if(customer.getId()==id) {
				resource=new Resource<Customer>(customer);break;
			}
		}
		ControllerLinkBuilder link=ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).viewAl());
		resource.add(link.withRel("All-Customers"));
		//ControllerLinkBuilder link2=ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).delete(id));
		//resource.add(link.withRel("Delete-This-Customer"));
		resource.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).delete(id)).withRel("Delete-This-Customer"));
		
		return resource;
		
	}

}
