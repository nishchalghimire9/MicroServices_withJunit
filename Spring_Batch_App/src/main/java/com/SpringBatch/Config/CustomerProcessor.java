package com.SpringBatch.Config;


import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.SpringBatch.entity.Customer;

// this class is to write the logic for item processor after we read the data we need to process the data

public class CustomerProcessor implements ItemProcessor <Customer , Customer> {  // input is customer object and out put is also customer object.
	
	public Customer process(Customer item) throws Exception{
		
		// if i need to processing the data logic goes here.
//		if (item.getCountry().equals("India")) {
//			return item;
//		}
		// above logic will just w
		return item;
	}
	
}
