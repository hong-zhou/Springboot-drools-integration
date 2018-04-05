package com.hongzhou.springbootdroolsintegration.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hongzhou.springbootdroolsintegration.model.Product;

@Service
public class ShoppingService {

	private final KieContainer kieContainer;
	
	@Autowired
	public ShoppingService(KieContainer kieContainer) {
		this.kieContainer = kieContainer;
	}
	
	public Product getProductDiscount(Product product) {
		// get the stateful session
		KieSession kieSession = kieContainer.newKieSession("rulesSession");
		kieSession.insert(product);
		kieSession.fireAllRules();
		kieSession.dispose();
		
		return product;
	}
}
