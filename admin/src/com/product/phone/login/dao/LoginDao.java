package com.product.phone.login.dao;

import java.util.List;
import java.util.Map;

import com.product.dbutil.jdbc.JdbcUtils;
import com.product.phone.login.service.LoginService;

public class LoginDao implements LoginService {

	private JdbcUtils jdbcUtils = null;

	public LoginDao() {
		jdbcUtils = new JdbcUtils();
	}

	@Override
	public boolean login(List<Object> params) {
		boolean flag = false;
		String sql = "select * from userinfo where username=? and password=?";
		try {
			jdbcUtils.getConnection();
			Map<String, Object> map = jdbcUtils.findSimpleResult(sql, params);
			flag = !map.isEmpty() ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtils.releaseConn();
		}
		return flag;
	}
}
