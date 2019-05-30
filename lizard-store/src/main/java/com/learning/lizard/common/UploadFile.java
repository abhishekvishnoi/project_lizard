package com.learning.lizard.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.learning.lizard.product.form.AddProductForm;

/**
 * Class for Uploading contents to server.
 * 
 * @author abhishek.vishnoi
 * 
 */
@Component
public class UploadFile {

	/**
	 * 
	 * @param addProductForm
	 * @param request
	 * @return
	 */
	public String upload(AddProductForm addProductForm,
			HttpServletRequest request) {

		MultipartFile fileData = addProductForm.getProductImage();

		System.out.println(fileData.getContentType());
		
		InputStream inputStream = null;
		OutputStream outputStream = null;

		String directoryPath = request.getSession().getServletContext()
				.getRealPath("/");

		String[] pathparts = StringUtils.split(directoryPath, "\\");

		String finaldirPath = pathparts[0];

		for (int i = 1; i < pathparts.length - 1; i++) {
			finaldirPath = finaldirPath + "\\" + pathparts[i];
		}

		directoryPath = finaldirPath;

		directoryPath = directoryPath + "\\" + "uploads" + "\\" + "products"
				+ "\\" + "images";
		System.out.println(directoryPath);

		// Create a filename.
		String fileName = null;
		if (StringUtils.isNotBlank(fileData.getOriginalFilename())) {
			String[] dbNameParts = StringUtils.split(
					fileData.getOriginalFilename(), ".");

			fileName = dbNameParts[0] + "." + dbNameParts[1];
		}

		String fileUploadName = directoryPath + "\\" + fileName;
		File dir = new File(directoryPath);

		// Check for directory Path.
		if (dir.exists())
			System.out.println("blahhh...!! Directory exists...");
		else
			// Make the directory if it doesn't exist.
			dir.mkdirs();

		// Uploading image File.
		if (fileData.getSize() > 0) {

			try {
				inputStream = fileData.getInputStream();
				outputStream = new FileOutputStream(fileUploadName);
			} catch (Exception e) {
				e.printStackTrace();
			}

			int readBytes = 0;
			byte[] buffer = new byte[8192];
			// Writing file to Output folder.

			try {
				while ((readBytes = inputStream.read(buffer, 0, 8192)) != -1) {
					outputStream.write(buffer, 0, readBytes);
				}
				inputStream.close();
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		// Getting the final path of uploaded image for db.
		String db_path = "";
		if (StringUtils.isNotBlank(fileData.getOriginalFilename()))
			db_path = "/uploads" + "/products" + "/images" + "/" + fileName;

		return db_path;

	}
}