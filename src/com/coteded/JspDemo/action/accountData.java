package com.coteded.JspDemo.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jooq.JSONFormat;
import org.jooq.JSONFormat.RecordFormat;

import com.coteded.JspDemo.dao.UserDao;
import com.coteded.JspDemo.jooq.tables.records.UserRecord;

/**
 * Servlet implementation class accountData
 */
@WebServlet("/accountData")
public class accountData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public accountData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserRecord record = null;
		try {
			record = UserDao.GetUser(request.getParameter("email"));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String employeeJsonString = record.formatJSON(new JSONFormat()
			    .header(false)
			    .recordFormat(RecordFormat.OBJECT));
		response.setContentType("application/json");
		response.getWriter().append(employeeJsonString);
	}



}
