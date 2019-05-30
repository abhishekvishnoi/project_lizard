package com.learning.lizard.persistence;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the order_product_tb_dtl database table.
 * 
 */
@Entity
@Table(name="order_product_tb_dtl")
@NamedQuery(name="OrderProductTbDtl.findAll", query="SELECT o FROM OrderProductTbDtl o")
public class OrderProductTbDtl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ordr_prdct_id", unique=true, nullable=false)
	private int ordrPrdctId;

	@Temporal(TemporalType.DATE)
	@Column(name="date_added")
	private Date dateAdded;

	@Column(name="product_price")
	private float productPrice;

	@Column(name="product_qty")
	private int productQty;

	//bi-directional many-to-one association to OrderTbMaster
	@ManyToOne
	@JoinColumn(name="order_id")
	private OrderTbMaster orderTbMaster;

	//bi-directional many-to-one association to ProductsTbMaster
	@ManyToOne
	@JoinColumn(name="product_id")
	private ProductsTbMaster productsTbMaster;

	public OrderProductTbDtl() {
	}

	public int getOrdrPrdctId() {
		return this.ordrPrdctId;
	}

	public void setOrdrPrdctId(int ordrPrdctId) {
		this.ordrPrdctId = ordrPrdctId;
	}

	public Date getDateAdded() {
		return this.dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public float getProductPrice() {
		return this.productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductQty() {
		return this.productQty;
	}

	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}

	public OrderTbMaster getOrderTbMaster() {
		return this.orderTbMaster;
	}

	public void setOrderTbMaster(OrderTbMaster orderTbMaster) {
		this.orderTbMaster = orderTbMaster;
	}

	public ProductsTbMaster getProductsTbMaster() {
		return this.productsTbMaster;
	}

	public void setProductsTbMaster(ProductsTbMaster productsTbMaster) {
		this.productsTbMaster = productsTbMaster;
	}

}