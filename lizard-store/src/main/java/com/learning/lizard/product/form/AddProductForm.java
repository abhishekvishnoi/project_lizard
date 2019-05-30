package com.learning.lizard.product.form;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class AddProductForm {
	
	 private Integer productId;

	 private String productName;
	
	 private String categoryName;
	 
	 private Float productPrice;
	 
	 private String productDesc;
	 
	 private CommonsMultipartFile productImage;
	 
	 private String productImagePath;
	 
	 private int pageMode;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Float productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public CommonsMultipartFile getProductImage() {
		return productImage;
	}

	public void setProductImage(CommonsMultipartFile productImage) {
		this.productImage = productImage;
	}

	public String getProductImagePath() {
		return productImagePath;
	}

	public void setProductImagePath(String productImagePath) {
		this.productImagePath = productImagePath;
	}

	public int getPageMode() {
		return pageMode;
	}

	public void setPageMode(int pageMode) {
		this.pageMode = pageMode;
	}

	/**
	 * @return the productId
	 */
	public Integer getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	 
	 
	
	
}
