package com.coteded.JspDemo.action;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Optional;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@MultipartConfig(fileSizeThreshold = 1024 * 1024,
maxFileSize = 1024 * 1024 * 5, 
maxRequestSize = 1024 * 1024 * 5 * 5)
@WebServlet("/UploadTest")
public class UploadTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UploadTest() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uploadPath = getServletContext().getRealPath("") + "files";
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) uploadDir.mkdir();
		
		
		for (Part part : request.getParts()) {
			String fileName = part.getSubmittedFileName();
			if(fileName == null)
				continue;
			
			File f = new File(fileName);
		    part.write(uploadPath + File.separator + f.getName());
		}
	}
	
	public String getFileExtension(String filename) {
		try {
			return  Optional.ofNullable(filename)
				      .filter(f -> f.contains("."))
				      .map(f -> f.substring(filename.lastIndexOf(".") + 1)).get();
		}catch(Exception e){
			return "txt";
		}
	}
	
	protected String generateRandomString(int length) {
		  	int leftLimit = 97; // letter 'a'
		    int rightLimit = 122; // letter 'z'
		    Random random = new Random();
	
		    String generatedString = random.ints(leftLimit, rightLimit + 1)
		      .limit(length)
		      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
		      .toString();
	
		   return generatedString;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
