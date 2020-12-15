package com.coteded.JspDemo.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * A utility class for sending e-mail messages
 * @author www.codejava.net
 *
 */
public class EmailService {
	ArrayList<Attachment> attachments = new ArrayList<Attachment>();
	
	public void sendEmail(String host, String port,
	final String userName, final String password, String toAddress,
	String subject, String message) 
	throws AddressException, MessagingException {
			// sets SMTP server properties
			Properties properties = new Properties();
			properties.put("mail.smtp.host", host);
			properties.put("mail.smtp.port", port);
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls.enable", "true");
			
			// creates a new session with an authenticator
			Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
			};
			
			Session session = Session.getInstance(properties, auth);
			
			// creates a new e-mail message
			Message msg = new MimeMessage(session);
			
			msg.setFrom(new InternetAddress(userName));
			InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
			msg.setRecipients(Message.RecipientType.TO, toAddresses);
			msg.setSubject(subject);
			msg.setSentDate(new Date());
			
	         // This mail has 2 part, the BODY and the embedded image
	         MimeMultipart multipart = new MimeMultipart("related");

	         BodyPart messageBodyPart = new MimeBodyPart();
	         String htmlText = message;
	         messageBodyPart.setContent(htmlText, "text/html");
	         // add it
	         multipart.addBodyPart(messageBodyPart);
	      
	         for(Attachment attachment:attachments) {
	        	 msg.setContent(multipart);
	        	 attach(attachment.getContentid(),attachment.getFileSource(),multipart);
	         }
	    
	         
	         // Send message
	         Transport.send(msg);
	}
	
	public void sendEmail(String host, String port,
	final String userName, final String password, String toAddress,
	String subject,HttpServletRequest req, HttpServletResponse resp, String template) 
	throws AddressException, MessagingException, ServletException, IOException {
		sendEmail(host,port,userName,password,toAddress,subject,JspRenderer.render(req, resp, template));
	}
	
	public void addAttachment(String contentid, String fileSource)  {
		attachments.add(new Attachment(contentid,fileSource));
	}
	
	private void attach(String contentid, String fileSource, MimeMultipart output) throws MessagingException {
		 // second part (the image)
		BodyPart messageBodyPart = new MimeBodyPart();
        DataSource fds = new FileDataSource(fileSource);

        messageBodyPart.setDataHandler(new DataHandler(fds));
        messageBodyPart.setHeader("Content-ID", "<" + contentid + ">");
        File f = new File(fileSource);
        messageBodyPart.setFileName(f.getName());
        output.addBodyPart(messageBodyPart);
	}
	
	public class Attachment{
		String contentid, fileSource;

		public Attachment(String contentid, String fileSource) {
			super();
			this.contentid = contentid;
			this.fileSource = fileSource;
		}

		public String getContentid() {
			return contentid;
		}

		public String getFileSource() {
			return fileSource;
		}
		
	}
}