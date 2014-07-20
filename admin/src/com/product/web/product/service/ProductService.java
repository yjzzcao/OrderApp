package com.product.web.product.service;

import java.util.List;
import java.util.Map;

public interface ProductService {

	public List<Map<String, Object>> listUser(int start, int end);

	public List<Map<String, Object>> listProduct(int start, int end);

	public Map<String, Object> searchUser(List<Object> params);
	
	public Map<String, Object> searchPro(List<Object> params);

	public boolean changeUser(List<Object> params);
	
	public boolean changeUserPswd(List<Object> params);

	public int getUseCount();
	
	public int getProCount();
}
