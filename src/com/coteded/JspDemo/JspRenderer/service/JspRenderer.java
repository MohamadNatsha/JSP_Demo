package com.coteded.JspDemo.JspRenderer.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JspRenderer {
	public static String render(HttpServletRequest req, HttpServletResponse resp, String template)
			throws ServletException, IOException {

		ResponseWrapper customResponse = new ResponseWrapper(resp);
		req.getRequestDispatcher(template).forward(req, customResponse);

		return customResponse.getOutput();
	}
}
