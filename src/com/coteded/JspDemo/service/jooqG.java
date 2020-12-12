package com.coteded.JspDemo.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.codegen.GenerationTool;
import org.jooq.impl.DSL;

/**
 * Servlet implementation class jooqG
 */
@WebServlet("/jooqG")
public class jooqG extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String  userName = "root";
	static String  password = "Test1234";
	static String  url = "jdbc:mysql://localhost:3306/jsp_demo?serverTimezone=UTC";

	
    public jooqG() throws SQLException {
        super();
    	
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, userName, password);
			DSLContext context = DSL.using(conn, SQLDialect.POSTGRES);
			GenerationTool.generate(
					  Files.readString(
					    Path.of(this.getServletContext().getRealPath("META-INF/jooq-config.xml"))
					  )    
					);
			System.out.println("test end");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
