package com.product.phone.active.dao;

import java.util.List;
import java.util.Map;

import com.product.dbutil.jdbc.JdbcUtils;
import com.product.phone.active.service.ActiveService;

public class ActiveDao implements ActiveService {

	private JdbcUtils jdbcUtils = null;

	public ActiveDao() {
		jdbcUtils = new JdbcUtils();
	}

	@Override
	public boolean receive(List<Object> params, List<Object> check) {
		boolean flag = false;
		jdbcUtils.getConnection();
		String sql = "insert into product(number,date,status,name) values(?,?,?,?)";
		String sql_c = "select * from product where number=? ";
		try {
			Map<String, Object> map = jdbcUtils.findSimpleResult(sql_c, check);
			flag = map.isEmpty() ? true : false;
			if (flag) {
				jdbcUtils.updateByPerparedStatement(sql, params);
			} else {
				System.out.println("单号已经存在！！");
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			jdbcUtils.releaseConn();
		}
		return flag;
	}

	@Override
	public boolean send(List<Object> params) {
		boolean flag = false;
		jdbcUtils.getConnection();
		String sql = "update product set date=?, status=?, name=? where number=?";
		try {
			flag = jdbcUtils.updateByPerparedStatement(sql, params);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			jdbcUtils.releaseConn();
		}
		return flag;
	}

}
