package com.learning.lizard.orders.service;

import java.util.List;

import com.learning.lizard.common.Cart;
import com.wect.orders.common.OrderVO;


public interface OrderService {
	
	public List<OrderVO> findAll();

	public boolean createOrder(Cart  cart , Integer userID) throws Exception ;
	
	public List<OrderVO> findAllByProperties(Integer userID);
	
}
