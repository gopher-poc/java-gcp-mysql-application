package com.capgemini.gcp.product.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.gcp.product.data.Product;
import com.capgemini.gcp.product.service.ProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
public class ProductController {

	Logger logger = LogManager.getLogger(ProductController.class);
	
	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping(value = "/getProductById")
	public Optional<Product> getProductById(@RequestParam(value = "productId", required = true) int productId) {
		logger.info("ProductController :: getProductById");
		return productService.getProductById(productId);
	}
	
	@GetMapping(value = "/getProductList")
	public List<Product> getProductList() {
		logger.info("ProductController :: getProductList");
		return productService.getProductList();
	}
	
	@PostMapping(value = "/save")
	public String saveProductDetails(@RequestBody Product product) {
		logger.info("ProductController :: save :: productName : {} ", product.getProductName());
		return productService.saveProductDetails(product);
	}
	
	@DeleteMapping(value = "/deleteProductById")
	public String deleteProduct(@RequestParam(value = "productId", required = true) int productId) {
		logger.info("ProductController :: deleteProduct :: productId : {} ", productId);
		return productService.deleteProduct(productId);
	}
}