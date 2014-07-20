package com.product.phone.active.service;

import java.util.List;

public interface ActiveService {

	public boolean receive(List<Object> params, List<Object> check);

	public boolean send(List<Object> params);

}
