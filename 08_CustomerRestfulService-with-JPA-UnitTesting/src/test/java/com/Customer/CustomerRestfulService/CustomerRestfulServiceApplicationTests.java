package com.Customer.CustomerRestfulService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.Customer.CustomerRestfulService.pojo.Customer;
import com.Customer.CustomerRestfulService.service.CustomerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRestfulServiceApplicationTests {

	
	
	@Test
	public void serviceLayerViewAllTest() {
		CustomerService service=mock(CustomerService.class);
		ArrayList<Customer> list=new ArrayList<Customer>();
		list.add(new Customer(1,"Samwise","Kolkata"));
		when(service.viewAll()).thenReturn(list);
		
		assertEquals(list, service.viewAll());
		verify(service).viewAll();	
	}
	
	
	@Test
	public void serviceLayerAddTest() {
		CustomerService service=mock(CustomerService.class);
		service.add(0,"","");
		service.add(0,"","");
		service.add(0,"","");
		
		verify(service,times(3)).add(0, "", "");	
	}
	
	@Test
	public void serviceLayerUpdateTest() {
		CustomerService service=mock(CustomerService.class);
		service.update(0, "", "");
		service.update(0, "", "");	
		service.update(0, "", "");
		
		verify(service,times(3)).update(0, "", "");	
	}
	@Test
	public void serviceLayerDeleteTest() {
		CustomerService service=mock(CustomerService.class);
		service.delete(0);
		service.delete(0);	
		service.delete(0);
		
		verify(service,times(3)).delete(0);	
	}

}
