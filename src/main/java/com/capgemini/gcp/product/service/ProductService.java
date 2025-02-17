package com.capgemini.gcp.product.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.gcp.product.data.Product;
import com.capgemini.gcp.product.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductService {

	Logger logger = LogManager.getLogger(ProductService.class);

	private ProductRepository productRepository;

	@Autowired
	public ProductService(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@Transactional
	public Optional<Product> getProductById(int productId) {
		logger.info("ProductService :: getProductById :: productId : {} ", productId);
		var resp = productRepository.findById(productId);
		logger.info("ProductService :: getProductById :: product : {} ", resp.isPresent());
		return resp;
	}

	public List<Product> getProductList() {

		var resp = productRepository.findAll();
		logger.info("ProductService :: getProductList :: productList : {} ", resp.isEmpty());
		return resp;

	}

	public String saveProductDetails(Product product) {
		
		logger.info("ProductService :: saveProductDetails :: product : {} ", product.getProductName());
		productRepository.save(product);
		return "Product detail saved successfully!";
	
	}

	public String deleteProduct(int productId) {
	
		logger.info("ProductService :: deleteProduct :: productId : {} ", productId);
		productRepository.deleteById(productId);
		return "Product deleted successfully!";
	
	}

}
