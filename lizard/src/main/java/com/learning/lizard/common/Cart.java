package com.learning.lizard.common;

import java.util.List;

public class Cart {

	private List<CartItem> cartItems;
	
	private long userID;

	private Float orderTtlAmnt;
	
	private Float vatPrcntge;
	
	private Float netVATAmnt;
	
	private Float netPayableAmnt;
	
	
	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public Float getOrderTtlAmnt() {
		return orderTtlAmnt;
	}

	public void setOrderTtlAmnt(Float orderTtlAmnt) {
		this.orderTtlAmnt = orderTtlAmnt;
	}

	public Float getVatPrcntge() {
		return vatPrcntge;
	}

	public void setVatPrcntge(Float vatPrcntge) {
		this.vatPrcntge = vatPrcntge;
	}

	public Float getNetVATAmnt() {
		return netVATAmnt;
	}

	public void setNetVATAmnt(Float netVATAmnt) {
		this.netVATAmnt = netVATAmnt;
	}

	public Float getNetPayableAmnt() {
		return netPayableAmnt;
	}

	public void setNetPayableAmnt(Float netPayableAmnt) {
		this.netPayableAmnt = netPayableAmnt;
	}
	
}
