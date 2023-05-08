package com.hackerrank.sample.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackerrank.sample.dto.FilteredProducts;
import com.hackerrank.sample.dto.Products;
import com.hackerrank.sample.dto.SortedProducts;

@RestController
public class SampleController {

	
	   final String uri = "https://jsonmock.hackerrank.com/api/inventory";
	   RestTemplate restTemplate = new RestTemplate();
	   String result = restTemplate.getForObject(uri, String.class);			
	   JSONObject root = new JSONObject(result);
	   
	   JSONArray data = root.getJSONArray("data");

		 ObjectMapper objectMapper = new ObjectMapper();
	   
	   
		
		@CrossOrigin
		@GetMapping("/filter/price/{initial_price}/{final_price}")  
		private ResponseEntity< ArrayList<FilteredProducts> > filtered_books(@PathVariable("initial_price") int init_price , @PathVariable("final_price") int final_price)   
		{  
			
			try {
				
			
					ArrayList<FilteredProducts> books = new ArrayList<FilteredProducts>();
					ArrayList<Products> totalProducts = new ArrayList<>();
					Products[] products = objectMapper.readValue(result, Products[].class);
					totalProducts.addAll(Arrays.asList(products));
					books.addAll(totalProducts.stream().
							filter(product -> product.getPrice() >= init_price ).
							filter(product -> product.getPrice() <= final_price ).map( product ->  new FilteredProducts(product.getBarCode())).collect(Collectors.toList()));
				    return new ResponseEntity<ArrayList<FilteredProducts>>(books, HttpStatus.OK);

			   
			    
			}catch(Exception E)
				{
	   	System.out.println("Error encountered : "+E.getMessage());
	    return new ResponseEntity<ArrayList<FilteredProducts>>(HttpStatus.NOT_FOUND);
				}
			
		}  
		
		
		@CrossOrigin
		@GetMapping("/sort/price")  
		private ResponseEntity<SortedProducts[]> sorted_books()   
		{  
			
			try {
				

				ArrayList<Products> totalProducts = new ArrayList<>();
				Products[] products = objectMapper.readValue(result, Products[].class);
				totalProducts.addAll(Arrays.asList(products));

				List<SortedProducts> list = totalProducts.stream().sorted(new Comparator<Products>() {
					@Override
					public int compare(Products o1, Products o2) {
						return o1.getPrice().compareTo(o2.getPrice());
					}
				}).map(products1 -> new SortedProducts(products1.getBarCode())).collect(Collectors.toList());


				return new ResponseEntity<SortedProducts[]>((SortedProducts[]) list.toArray(), HttpStatus.OK);
			    
			}catch(Exception E)
				{
	   		System.out.println("Error encountered : "+E.getMessage());
	    	return new ResponseEntity<SortedProducts[]>(HttpStatus.NOT_FOUND);
				}
			
		}  
		
		
	
}
