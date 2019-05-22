package com.learning.lizard.product.service;

import java.util.List;

import com.learning.lizard.persistence.ProductsTbMaster;
import com.learning.lizard.product.form.AddProductForm;

/**
 * Product Service interface
 * 
 * @author abhishek.vishnoi
 *
 */
public interface ProductService {

	public List<ProductsTbMaster> findAll();

	public boolean createProduct(AddProductForm AddProductForm);
	
	public boolean deleteProduct(int productId);
	
	public ProductsTbMaster findByID(int productId);
	
/*	public List<ProductsTbMaster> findAllProductsByProperty(Cart cart);*/
	
	public AddProductForm findProductForm(int productId);
	
}
