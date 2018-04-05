package com.hongzhou.springbootdroolsintegration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hongzhou.springbootdroolsintegration.model.Product;
import com.hongzhou.springbootdroolsintegration.service.ShoppingService;

@RestController
public class ShoppingController {

	private final ShoppingService shoppingService;
	
	@Autowired
	public ShoppingController(ShoppingService shoppingService) {
		this.shoppingService = shoppingService;
	}
	
	/**
	 * http://localhost:8080/getDiscount?type=gold
	 * @param type
	 * @return
	 */
	@RequestMapping(value="/getDiscount", method=RequestMethod.GET, produces="application/json")
	public Product getQuestions(@RequestParam(required=true) String type) {
		Product product = new Product();
		product.setType(type);
		shoppingService.getProductDiscount(product);
		
		return product;
	}
}
