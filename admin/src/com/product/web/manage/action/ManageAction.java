package com.product.web.manage.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.web.manage.dao.ManageDao;
import com.product.web.manage.service.ManageService;

public class ManageAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ManageService service;

	public ManageAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() throws ServletException {
		service = new ManageDao();
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
		String name = request.getParameter("name");
		String pswd = request.getParameter("pswd");
		List<Object> params = new ArrayList<Object>();
		params.add(name);
		params.add(pswd);
		boolean flag = service.login(params);
		if (flag) {
			request.getSession().setAttribute("name", name);
			response.sendRedirect(path + "/index.jsp");
		} else {
			response.sendRedirect(path + "/manage.jsp");
		}
		out.flush();
		out.close();
	}
}
