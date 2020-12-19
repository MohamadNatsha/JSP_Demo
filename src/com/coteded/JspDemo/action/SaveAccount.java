package com.coteded.JspDemo.action;

import com.coteded.JspDemo.JspRenderer.service.JspRenderer;
import com.coteded.JspDemo.bo.UserBean;
import com.coteded.JspDemo.dao.*;
import com.coteded.JspDemo.jooq.enums.UserAccounttype;
import com.coteded.JspDemo.service.EmailService;
import com.coteded.JspDemo.service.UploadFile;
import com.coteded.JspDemo.service.aws.S3Link;
import com.coteded.JspDemo.service.aws.S3Upload;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class AddUserAction
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
@WebServlet(name = "UploadFile", urlPatterns = { "/SaveAccount" }, initParams = {
		@WebInitParam(name = "uploadpath", value = "/var/www/upload/") })
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/saveAccount.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String desc = request.getParameter("desc");
		UserAccounttype type = UserAccounttype.valueOf(request.getParameter("type"));

		// upload
		ServletConfig sc = getServletConfig();
		String uploadPath = sc.getInitParameter("uploadpath");

		// Upload the image
		String image = null;
		Part imagePart = request.getPart("image");
		if (!imagePart.getSubmittedFileName().equals("")) {
			image = UUID.randomUUID().toString();
			// Upload to the Server
			UploadFile uploadFile = new UploadFile();
			uploadFile.Upload(imagePart, uploadPath, image);
			// Upload to the S3
			S3Upload s3Upload = new S3Upload();
			s3Upload.setContentType("image/jpeg");
			s3Upload.upload(uploadPath + image, image);
		}

		// Upload The video
		String video = null;
		Part videoPart = request.getPart("video");
		if (!videoPart.getSubmittedFileName().equals("")) {
			// Upload to the Server
			video = UUID.randomUUID().toString();
			UploadFile uploadFile = new UploadFile();
			uploadFile.Upload(videoPart, uploadPath, video);
			// Upload to the S3
			S3Upload s3Upload = new S3Upload();
			s3Upload.setContentType("video/mp4");
			s3Upload.upload(uploadPath + video, video);
		}

		UserBean userBean = new UserBean(name, phone, email, desc, image, video, type);
		try {
			// add User to the database
			UserDao userDao = new UserDao();
			userDao.AddUser(userBean);
			request.setAttribute("msg", "The account was added successfully");
			// send email to the user
			List<String> attachments = new ArrayList<String>();
			attachments.add(image);
			attachments.add(video);
			sendFormEmail(request, response, "/emailTemplate.jsp", attachments);
			doGet(request, response);
		} catch (ClassNotFoundException | SQLException | MessagingException e) {
			e.printStackTrace();
			
		}
	}

	public void sendFormEmail(HttpServletRequest request, HttpServletResponse response, String template,
			List<String> attachments) throws AddressException, MessagingException, ServletException, IOException {
		String host, port, user, pass;
		ServletContext context = getServletContext();
		host = context.getInitParameter("host");
		port = context.getInitParameter("port");
		user = context.getInitParameter("user");
		pass = context.getInitParameter("pass");
		String recipient = request.getParameter("email");
		String subject = "Joining Our Community";

		ServletConfig sc = getServletConfig();
		String uploadPath = sc.getInitParameter("uploadpath");

		int i = 0;
		EmailService email = new EmailService(host, port, user, pass);
		for (String attachment : attachments) {
			i++;
			if (attachment == null)
				continue;

			email.addAttachment("a" + String.valueOf(i), uploadPath + attachment);
		}

		email.sendEmail(recipient, subject, JspRenderer.render(request, response, template));
	}

}
