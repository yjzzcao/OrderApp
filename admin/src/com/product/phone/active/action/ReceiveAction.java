package com.product.phone.active.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.phone.active.dao.ActiveDao;
import com.product.phone.active.service.ActiveService;
import com.product.phone.active.tools.DateToString;

public class ReceiveAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ActiveService service = null;

	public ReceiveAction() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		service = new ActiveDao();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String re_number = (String) request.getParameter("re_number");
		String name = (String) request.getParameter("username");
		Date date = new Date();
		String dateString = DateToString.dateToString(date);
		String status = "receive";
		List<Object> params = new ArrayList<Object>();
		List<Object> check = new ArrayList<Object>();
		params.add(re_number);
		params.add(dateString);
		params.add(status);
		params.add(name);
		check.add(re_number);
		boolean flag = service.receive(params, check);
		if (flag) {
			response.sendRedirect(path + "/active.jsp");
		} else {
			response.sendRedirect(path + "/error.jsp");
		}
		out.flush();
		out.close();
	}

}
