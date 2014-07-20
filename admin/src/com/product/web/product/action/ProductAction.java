package com.product.web.product.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.product.web.product.dao.ProductDao;
import com.product.web.product.service.ProductService;
import com.product.web.product.util.DividePage;

public class ProductAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductService service = null;

	public ProductAction() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		service = new ProductDao();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String action_flag = request.getParameter("action_flag");
		if (action_flag.equals("userlist")) {
			listUser(request, response);
		} else if (action_flag.equals("searchuser")) {
			searchUser(request, response);
		} else if (action_flag.equals("changeuser")) {
			changeUser(request, response);
		} else if (action_flag.equals("productlist")) {
			listProduct(request, response);
		} else if (action_flag.equals("searchpro")) {
			searchPro(request, response);
		} else if (action_flag.equals("password")) {
			changePswd(request, response);
		}
	}

	private void searchPro(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String number = request.getParameter("number");
		List<Object> params = new ArrayList<Object>();
		params.add(number);
		Map<String, Object> map = service.searchPro(params);
		JSONObject json = JSONObject.fromObject(map);
		String str = json.toString();
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		PrintWriter out = response.getWriter();
		// System.out.println(str);
		out.println(str);
		out.flush();
		out.close();

	}

	private void changeUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String realname = request.getParameter("realname");
		String status = request.getParameter("status");
		String password = request.getParameter("userPswd");
		String username = request.getParameter("username");
		List<Object> params = new ArrayList<Object>();
		params.add(realname);
		params.add(status);
		params.add(username);
		service.changeUser(params);
		if (password != null && password != "") {
			List<Object> paramsPswd = new ArrayList<Object>();
			paramsPswd.add(password);
			paramsPswd.add(username);
			service.changeUserPswd(paramsPswd);
		}
		out.flush();
		out.close();
	}

	private void searchUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		List<Object> params = new ArrayList<Object>();
		params.add(username);
		Map<String, Object> map = service.searchUser(params);
		JSONObject json = JSONObject.fromObject(map);
		String str = json.toString();
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		PrintWriter out = response.getWriter();
		// System.out.println(str);
		out.println(str);
		out.flush();
		out.close();
	}

	private void listUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int recordCount = service.getUseCount();
		int currentPage = 1;
		String pageNum = request.getParameter("pageNumU");
		if (pageNum != null) {
			currentPage = Integer.parseInt(pageNum);
		}
		DividePage pUtil = new DividePage(5, recordCount, currentPage);
		int start = pUtil.getFromIndex();
		int end = pUtil.getToIndex();
		List<Map<String, Object>> list = service.listUser(start, end);
		JSONArray json = JSONArray.fromObject(list);
		JSONObject pUtilJson = JSONObject.fromObject(pUtil);
		json.add(pUtilJson);
		String str = json.toString();
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		PrintWriter out = response.getWriter();
		// System.out.println(str);
		out.println(str);
		out.flush();
		out.close();
	}

	private void listProduct(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int recordCount = service.getProCount();
		int currentPage = 1;
		String pageNum = request.getParameter("pageNumP");
		if (pageNum != null) {
			currentPage = Integer.parseInt(pageNum);
		}
		DividePage pUtil = new DividePage(5, recordCount, currentPage);
		int start = pUtil.getFromIndex();
		int end = pUtil.getToIndex();
		List<Map<String, Object>> list = service.listProduct(start, end);
		JSONArray json = JSONArray.fromObject(list);
		JSONObject pUtilJson = JSONObject.fromObject(pUtil);
		json.add(pUtilJson);
		String str = json.toString();
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		PrintWriter out = response.getWriter();
		// System.out.println(str);
		out.println(str);
		out.flush();
		out.close();
	}

	private void changePswd(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
