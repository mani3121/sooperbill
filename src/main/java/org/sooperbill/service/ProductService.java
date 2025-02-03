package org.sooperbill.service;

import java.util.List;

import org.sooperbill.model.Product;

public interface ProductService {
	
	 Product saveProduct(Product product);
	 List<Product> getAllProducts();

}
