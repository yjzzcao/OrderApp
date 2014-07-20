package com.product.phone.login.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.phone.login.dao.LoginDao;
import com.product.phone.login.service.LoginService;

public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private LoginService service;

	public LoginAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() throws ServletException {
		service = new LoginDao();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("gbk");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		List<Object> params = new ArrayList<Object>();
		params.add(username);
		params.add(password);
		boolean flag = service.login(params);
		if (flag) {
			request.getSession().setAttribute("username", username);
			response.sendRedirect(path + "/active.jsp");
		} else {
			response.sendRedirect(path + "/login.jsp");
		}
		out.flush();
		out.close();
	}
}
