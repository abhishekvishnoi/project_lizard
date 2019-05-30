package com.learning.lizard.orders.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learning.lizard.common.Cart;
import com.learning.lizard.common.CartItem;
import com.learning.lizard.dao.GenericDAO;
import com.learning.lizard.persistence.OrderProductTbDtl;
import com.learning.lizard.persistence.OrderTbMaster;
import com.learning.lizard.product.service.ProductService;
import com.learning.lizard.user.service.UserService;
import com.wect.orders.common.OrderVO;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private ProductService productService;

	@Autowired
	private UserService userService;

	private GenericDAO<OrderTbMaster> dao;

	@Autowired
	public void setDAO(GenericDAO<OrderTbMaster> daoToSet) {
		dao = daoToSet;
		dao.setClazz(OrderTbMaster.class);
	}

	
	private List<OrderVO> getVoList(List<OrderTbMaster> db_orderList)
	{
		List<OrderVO> orderList = new ArrayList<>();
		
		for (int itr = 0; itr < db_orderList.size(); itr++) {
			OrderVO order = new OrderVO();

			order.setEmailID(db_orderList.get(itr).getUserTbMaster()
					.getUserEmail());
			order.setUserName(db_orderList.get(itr).getUserTbMaster()
					.getUserName());
			order.setOrderID(db_orderList.get(itr).getOrderId());

			orderList.add(order);
		}
		return orderList;
		
	}
	


	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wect.orders.service.OrderService#findAll()
	 */
	@Transactional
	public List<OrderVO> findAll() {

		List<OrderTbMaster> db_orderList = dao.findAll();

		List<OrderVO> orderList =  getVoList(db_orderList);

		return orderList;

	}
	
	
	@Transactional
	public List<OrderVO> findAllByProperties(Integer userID) {
		
		HashMap< String , Object> properties  = new HashMap<String , Object>();
		
		properties.put("userTbMaster", userService.findByID(userID));

		List<OrderTbMaster> db_orderList = dao.findAllByProperty(properties);

		List<OrderVO> orderList =  getVoList(db_orderList);

		return orderList;

	}
	
	

	/*
	 * Service Method to create a new order.
	 * (non-Javadoc)
	 * @see com.wect.orders.service.OrderService#createProduct(com.wect.common.Cart, java.lang.Integer)
	 */
	@Transactional
	public boolean createOrder(Cart cart, Integer userID) throws Exception {

		Integer prdctID;

		List<CartItem> cartItems = cart.getCartItems();
		
		Date date = new Date();
		
		if (cartItems.size() > 0) {

			OrderProductTbDtl orderProductTbDtl;

			List<OrderProductTbDtl> orderProductTbDtlList = new ArrayList<>();

			OrderTbMaster ordrEntty = new OrderTbMaster();

			ordrEntty.setDateAdded(new Timestamp(date.getTime()));

			ordrEntty.setOrdrNmbr(generateOrderNumber());

			ordrEntty.setUserTbMaster(userService.findByID(userID));

			for (CartItem cartItem : cartItems) {

				orderProductTbDtl = new OrderProductTbDtl();

				prdctID = cartItem.getProductID();

				// cartItem.getQuantity();
				orderProductTbDtl.setProductPrice(10);

				orderProductTbDtl.setProductQty(1);

				orderProductTbDtl.setProductsTbMaster(productService
						.findByID(prdctID));

				orderProductTbDtlList.add(orderProductTbDtl);
			}

			ordrEntty.setOrderProductTbDtls(orderProductTbDtlList);
			
			dao.create(ordrEntty);

			return true;
		} else {

			return false;
		}

	}

	/*
	 * Private method to generate a random number to form a Unique Order Number
	 */
	private String generateOrderNumber() {
		
		String alphaNumerics = "qwertyuiopasdfghjklzxcvbnm1234567890";
		String temp = "";
		for (int i = 0; i < 8; i++) {
			temp += alphaNumerics.charAt((int) (Math.random() * alphaNumerics.length()));
		}
		
		String ordrNmbr = "ORDR - " + temp;

		return ordrNmbr;

	}

}
