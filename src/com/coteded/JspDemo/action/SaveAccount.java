package com.coteded.JspDemo.action;
import com.coteded.JspDemo.bo.AccountType;
import com.coteded.JspDemo.bo.UserInfo;
import com.coteded.JspDemo.dao.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddUserAction
 */
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
		AccountType type = AccountType.Admin;
		String image = request.getParameter("image");
		String video = request.getParameter("video");
		
		UserInfo user = new UserInfo(name,phone,email,desc,image,video,type);
		
		UserDao.AddUser(user);
		doGet(request,response);
	}

}
