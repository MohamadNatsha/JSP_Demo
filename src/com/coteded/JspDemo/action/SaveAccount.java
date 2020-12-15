package com.coteded.JspDemo.action;
import com.coteded.JspDemo.dao.*;
import com.coteded.JspDemo.jooq.enums.UserAccounttype;
import com.coteded.JspDemo.service.EmailService;
import com.coteded.JspDemo.service.UploadFilesService;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddUserAction
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
maxFileSize = 1024 * 1024 * 5, 
maxRequestSize = 1024 * 1024 * 5 * 5)
@WebServlet("/SaveAccount")
public class SaveAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/saveAccount.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String desc = request.getParameter("desc");
		UserAccounttype type = UserAccounttype.valueOf(request.getParameter("type"));
		
		String uploadPath = getServletContext().getRealPath("") + "files";
		ArrayList<String> filesPathes = UploadFilesService.Upload(uploadPath,"files",request);
		String image = filesPathes.get(0);
		String video = filesPathes.get(1);
		System.out.println(image);
		System.out.println(video);
		

		try {
			UserDao.AddUser(name,type,phone,email,desc,image,video);
			request.setAttribute("msg","The account was added successfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("msg","Account was not added");
			
		}
	
	
		try {
			sendFormEmail(request,response,"/emailTemplate.jsp",filesPathes);
		} catch (Exception e) {

		}
		
		
		doGet(request,response);
		
	}
	
	
	public Boolean sendFormEmail(HttpServletRequest request, HttpServletResponse response,String template,ArrayList<String> attachments) {
		String host, port, user, pass;
	 	ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        user = context.getInitParameter("user");
        pass = context.getInitParameter("pass");
        String recipient = request.getParameter("email");
        String subject = "Joining Our Community";
 
        
        try {
        	int i = 0;
        	EmailService email = new EmailService();
        	for(String attachment:attachments) {
        		i++;
        		if(attachment == null)
        			continue;
        		
        		email.addAttachment("a" + String.valueOf(i), getServletContext().getRealPath("") + attachment);
        	}
        	
        	email.sendEmail(host, port, user, pass, recipient, subject, request,response,template);
            System.out.println("email sent");
            return true;
        } catch (Exception ex) {
        	System.out.println("email failed");
            ex.printStackTrace();
            return false;
        } 
        
        
	} 	

}
