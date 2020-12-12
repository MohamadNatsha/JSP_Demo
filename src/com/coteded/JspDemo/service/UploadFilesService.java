package com.coteded.JspDemo.service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


public class UploadFilesService {
	public static ArrayList<String> Upload(String uploadPath,HttpServletRequest request) throws ServletException, IOException {
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) uploadDir.mkdir();
		
		ArrayList<String> files = new ArrayList<String>();
		
		for (Part part : request.getParts()) {
			String fileName = part.getSubmittedFileName();
			
			if(fileName == null)
				continue;
			
			File f = new File(fileName);
			files.add(f.getName());
		    try {
		    	part.write(uploadPath + File.separator + f.getName());
		    }catch(Exception e) {
		    	// nothing there is no file uploaded
		    }
		}
		
		return files;
	}
	
	public static String getFileExtension(String filename) {
		try {
			return  Optional.ofNullable(filename)
				      .filter(f -> f.contains("."))
				      .map(f -> f.substring(filename.lastIndexOf(".") + 1)).get();
		}catch(Exception e){
			return "txt";
		}
	}
	
	protected static String generateRandomString(int length) {
		  	int leftLimit = 97; // letter 'a'
		    int rightLimit = 122; // letter 'z'
		    Random random = new Random();
	
		    String generatedString = random.ints(leftLimit, rightLimit + 1)
		      .limit(length)
		      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
		      .toString();
	
		   return generatedString;
	}
}
