package com.product.phone.register.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.phone.register.dao.RegisterDao;
import com.product.phone.register.service.RegisterService;

public class RegisterAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RegisterService service = null;

	public RegisterAction() {
		super();
	}

	public void init() throws ServletException {
		service = new RegisterDao();
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
		int status = 1;
		List<Object> check = new ArrayList<Object>();
		check.add(username);
		List<Object> params = new ArrayList<Object>();
		params.add(username);
		params.add(password);
		params.add(status);
		boolean flag = service.registerUser(params, check);
		if (flag) {
			response.sendRedirect(path + "/login.jsp");
		} else {
			response.sendRedirect(path + "/pass.jsp");
		}
		out.flush();
		out.close();
	}

	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}
}
