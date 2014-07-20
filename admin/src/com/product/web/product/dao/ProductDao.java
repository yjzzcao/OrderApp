package com.product.web.product.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.product.dbutil.jdbc.JdbcUtils;
import com.product.web.product.service.ProductService;

public class ProductDao implements ProductService {

	private JdbcUtils jdbcUtils = new JdbcUtils();

	@Override
	public List<Map<String, Object>> listUser(int start, int end) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		String sql = "select * from userinfo ";
		StringBuffer buffer = new StringBuffer(sql);
		List<Object> params = new ArrayList<Object>();
		buffer.append("limit ?,? ");
		params.add(start);
		params.add(end);
		try {
			jdbcUtils.getConnection();
			list = jdbcUtils.findMoreResult(buffer.toString(), params);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			jdbcUtils.releaseConn();
		}
		return list;
	}

	@Override
	public List<Map<String, Object>> listProduct(int start, int end) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		String sql = "select * from product ";
		StringBuffer buffer = new StringBuffer(sql);
		List<Object> params = new ArrayList<Object>();
		buffer.append("limit ?,? ");
		params.add(start);
		params.add(end);
		try {
			jdbcUtils.getConnection();
			list = jdbcUtils.findMoreResult(buffer.toString(), params);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			jdbcUtils.releaseConn();
		}
		return list;
	}

	@Override
	public Map<String, Object> searchUser(List<Object> params) {
		Map<String, Object> map = new HashMap<String, Object>();
		String sql = "select * from userinfo where username=?";
		try {
			jdbcUtils.getConnection();
			map = jdbcUtils.findSimpleResult(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtils.releaseConn();
		}
		return map;
	}

	@Override
	public boolean changeUser(List<Object> params) {
		boolean flag = false;
		jdbcUtils.getConnection();
		String sql = "update userinfo set realname=?, status=? where username=?";
		try {
			flag = jdbcUtils.updateByPerparedStatement(sql, params);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			jdbcUtils.releaseConn();
		}
		return flag;
	}

	@Override
	public boolean changeUserPswd(List<Object> paramsPswd) {
		boolean flag = false;
		jdbcUtils.getConnection();
		String sql = "update userinfo set password=? where username=?";
		try {
			flag = jdbcUtils.updateByPerparedStatement(sql, paramsPswd);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			jdbcUtils.releaseConn();
		}
		return flag;
	}

	@Override
	public int getUseCount() {
		int result = 0;
		Map<String, Object> map = null;
		String sql = "select count(*) mycount from userinfo";
		try {
			jdbcUtils.getConnection();
			map = jdbcUtils.findSimpleResult(sql, null);
			result = Integer.parseInt(map.get("mycount").toString());
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			jdbcUtils.releaseConn();
		}
		return result;
	}

	public int getProCount() {
		int result = 0;
		Map<String, Object> map = null;
		String sql = "select count(*) mycount from product";
		try {
			jdbcUtils.getConnection();
			map = jdbcUtils.findSimpleResult(sql, null);
			result = Integer.parseInt(map.get("mycount").toString());
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			jdbcUtils.releaseConn();
		}
		return result;
	}

	@Override
	public Map<String, Object> searchPro(List<Object> params) {
		Map<String, Object> map = new HashMap<String, Object>();
		String sql = "select * from product where number=?";
		try {
			jdbcUtils.getConnection();
			map = jdbcUtils.findSimpleResult(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtils.releaseConn();
		}
		return map;
	}

}
