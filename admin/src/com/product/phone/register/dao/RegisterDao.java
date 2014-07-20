package com.product.phone.register.dao;

import java.util.List;
import java.util.Map;

import com.product.dbutil.jdbc.JdbcUtils;
import com.product.phone.register.service.RegisterService;

public class RegisterDao implements RegisterService {

	private JdbcUtils utils = null;

	public RegisterDao() {
		utils = new JdbcUtils();
	}

	@Override
	public boolean registerUser(List<Object> params, List<Object> check) {
		boolean flag = false;
		utils.getConnection();
		String sqlCheck = "select * from userinfo where username=? ";
		String sql = "insert into userinfo(username,password,status) values(?,?,?)";
		try {
			Map<String, Object> map = utils.findSimpleResult(sqlCheck, check);
			flag = map.isEmpty() ? true : false;
			if (flag) {
				utils.updateByPerparedStatement(sql, params);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			utils.releaseConn();
		}
		return flag;
	}
}
