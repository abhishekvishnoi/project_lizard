package com.learning.lizard.product.form;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProductFormValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object command, Errors errors) {
		// TODO Auto-generated method stub
		
		AddProductForm addProductForm = (AddProductForm) command;
		
		
		/**
		 * Validations for file extensions.
		 * 
		 */
		if (StringUtils.isNotBlank(addProductForm.getProductImage()
				.getOriginalFilename())) {

			// Validations for image extensions.
			if (addProductForm.getProductImage().getOriginalFilename()
					.endsWith(".jpg")
					|| addProductForm.getProductImage().getOriginalFilename()
							.endsWith(".JPG")) {

			
			} else if (addProductForm.getProductImage().getOriginalFilename()
					.endsWith(".jpeg")
					|| addProductForm.getProductImage().getOriginalFilename()
							.endsWith(".JPEG")) {

			

			} else if (addProductForm.getProductImage().getOriginalFilename()
					.endsWith(".png")
					|| addProductForm.getProductImage().getOriginalFilename()
							.endsWith(".PNG")) {
			
			} else {
				
				System.out.println("not a valid image type");
				
				errors.rejectValue("fileData", "not a valid image type" ,"not a valid image type");
			}

		}
		
		
		
		
		
		
		
		
		
		
		
	}

}
