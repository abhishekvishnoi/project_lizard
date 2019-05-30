package com.learning.lizard.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learning.lizard.dao.GenericDAO;
import com.learning.lizard.persistence.ProductsTbMaster;
import com.learning.lizard.product.form.AddProductForm;

/**
 * Service for operations on Products
 * 
 * @author abhishek.vishnoi
 * 
 */
@Service
public class ProductServiceImpl implements ProductService {

	private GenericDAO<ProductsTbMaster> dao;

	@Autowired
	public void setDAO(GenericDAO<ProductsTbMaster> daoToSet) {
		dao = daoToSet;
		dao.setClazz(ProductsTbMaster.class);
	}

	/*
	 * Service Method to find all the products from the Database.(non-Javadoc)
	 * 
	 * @see com.wect.services.ProductService#findAll()
	 */
	@Transactional
	@Override
	public List<ProductsTbMaster> findAll() {

		List<ProductsTbMaster> prod_list = dao.findAll();

		return prod_list;
	}

	/*
	 * Service Method to Create a new product (non-Javadoc)
	 * 
	 * @see
	 * com.wect.product.service.ProductService#createProduct(com.wect.product
	 * .form.AddProductForm)
	 */
	@Override
	@Transactional
	public boolean createProduct(AddProductForm addProductForm) {

		ProductsTbMaster newProduct = new ProductsTbMaster();

		newProduct.setProductName(addProductForm.getProductName());
		newProduct.setProductPrice(Float.valueOf(addProductForm
				.getProductPrice()));
		newProduct.setProductImage(addProductForm.getProductImagePath());

		dao.create(newProduct);

		return true;
	}

	/*
	 * Service MEthod to delete a product entity from database (non-Javadoc)
	 * 
	 * @see com.wect.product.service.ProductService#deleteProduct(int)
	 */
	@Transactional
	public boolean deleteProduct(int productId) {

		System.out.println("deleting product with ID -->" + productId);

		dao.deleteById(productId);

		return true;
	}

	/*
	 * Service method to find a product on basis of ID.
	 */
	@Transactional
	public ProductsTbMaster findByID(int productId) {

		ProductsTbMaster productEntity = dao.findByID(productId);

		return productEntity;
	}

	/*
	 * (non-Javadoc)
	 * Service Method to fin the products by given properties
	 * @see com.wect.product.service.ProductService#findAllProductsByProperty(com.wect.common.Cart)
	 */
	/*@Transactional
	public List<ProductsTbMaster> findAllProductsByProperty(Cart cart) {

		List<CartItem> cartItems = cart.getCartItems();

		String propertyName = "productId";
		
		List<Integer> properties = new LinkedList<Integer>();

		for (int itr = 0; itr < cartItems.size(); itr++) {
			properties.add(cartItems.get(itr).getProductID());
		}

		List<ProductsTbMaster> cartList = dao
				.findAllByOr(properties , propertyName);

		return cartList;
	}*/
	
	/*
	 * (non-Javadoc)
	 * @see com.wect.product.service.ProductService#findProductForm(int)
	 */
	@Transactional
	public AddProductForm findProductForm(int productId)
	{
		AddProductForm  addProductForm = new AddProductForm();
		
		ProductsTbMaster productEntity = findByID(productId);
		
		addProductForm.setProductName(productEntity.getProductName());
		addProductForm.setProductPrice(productEntity.getProductPrice());
		addProductForm.setProductImagePath(productEntity.getProductImage());
		addProductForm.setProductDesc(productEntity.getProductName());
	
		
		return addProductForm;
		
		
	}
}
