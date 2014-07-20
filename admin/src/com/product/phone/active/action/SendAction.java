package com.product.phone.active.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.phone.active.dao.ActiveDao;
import com.product.phone.active.service.ActiveService;
import com.product.phone.active.tools.DateToString;

public class SendAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ActiveService service = null;

    public SendAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		service = new ActiveDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String se_number = request.getParameter("se_number");
		String name = (String) request.getParameter("username");
		Date date = new Date();
		String dateString = DateToString.dateToString(date);
		String status = "send";
		List<Object> params = new ArrayList<Object>();
		params.add(dateString);
		params.add(status);
		params.add(name);
		params.add(se_number);
		boolean flag = service.send(params);
		if (flag) {
			response.sendRedirect(path + "/active.jsp");
		} else {
			response.sendRedirect(path + "/error.jsp");
		}
		out.flush();
		out.close();
	}

}
