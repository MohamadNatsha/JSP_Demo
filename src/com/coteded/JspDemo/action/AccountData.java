package com.coteded.JspDemo.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jooq.JSONFormat;
import org.jooq.JSONFormat.RecordFormat;

import com.coteded.JspDemo.bo.UserBean;
import com.coteded.JspDemo.dao.UserDao;
import com.coteded.JspDemo.jooq.tables.records.UserRecord;

/**
 * Servlet implementation class accountData
 */
@WebServlet("/accountData")
public class AccountData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AccountData() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// get User information
			UserDao userDao = new UserDao();
			UserBean userBean = userDao.GetUser(request.getParameter("email"));
			
			// render the Jsp for the user view
			request.setAttribute("user", userBean);
			RequestDispatcher dispatcher = request.getRequestDispatcher("userData.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
