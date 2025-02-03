package org.sooperbill.service.impl;

import java.util.List;
import org.slf4j.LoggerFactory;
import org.sooperbill.model.Product;
import org.sooperbill.repository.ProductRepository;
import org.sooperbill.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ProductService.class);
    
	@Autowired
	ProductRepository productRepository;

	@Override
	public Product saveProduct(Product product) {
		logger.info("Saving product: {}", product);
        Product savedProduct = productRepository.save(product);
        logger.info("Saved product: {}", savedProduct);
        return savedProduct;
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}
	

}
