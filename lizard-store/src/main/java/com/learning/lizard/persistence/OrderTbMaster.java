package com.learning.lizard.persistence;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the order_tb_master database table.
 * 
 */
@Entity
@Table(name="order_tb_master")
@NamedQuery(name="OrderTbMaster.findAll", query="SELECT o FROM OrderTbMaster o")
public class OrderTbMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="order_id", unique=true, nullable=false)
	private int orderId;

	@Temporal(TemporalType.DATE)
	@Column(name="date_added")
	private Date dateAdded;

	@Column(name="ordr_nmbr", length=32)
	private String ordrNmbr;

	@Column(name="ordr_prc")
	private float ordrPrc;

	//bi-directional many-to-one association to OrderProductTbDtl
	@OneToMany(mappedBy="orderTbMaster")
	private List<OrderProductTbDtl> orderProductTbDtls;

	//bi-directional many-to-one association to ProductsTbMaster
	@ManyToOne
	@JoinColumn(name="product_id")
	private ProductsTbMaster productsTbMaster;

	//bi-directional many-to-one association to UserTbMaster
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserTbMaster userTbMaster;

	public OrderTbMaster() {
	}

	public int getOrderId() {
		return this.orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getDateAdded() {
		return this.dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public String getOrdrNmbr() {
		return this.ordrNmbr;
	}

	public void setOrdrNmbr(String ordrNmbr) {
		this.ordrNmbr = ordrNmbr;
	}

	public float getOrdrPrc() {
		return this.ordrPrc;
	}

	public void setOrdrPrc(float ordrPrc) {
		this.ordrPrc = ordrPrc;
	}

	public List<OrderProductTbDtl> getOrderProductTbDtls() {
		return this.orderProductTbDtls;
	}

	public void setOrderProductTbDtls(List<OrderProductTbDtl> orderProductTbDtls) {
		this.orderProductTbDtls = orderProductTbDtls;
	}

	public OrderProductTbDtl addOrderProductTbDtl(OrderProductTbDtl orderProductTbDtl) {
		getOrderProductTbDtls().add(orderProductTbDtl);
		orderProductTbDtl.setOrderTbMaster(this);

		return orderProductTbDtl;
	}

	public OrderProductTbDtl removeOrderProductTbDtl(OrderProductTbDtl orderProductTbDtl) {
		getOrderProductTbDtls().remove(orderProductTbDtl);
		orderProductTbDtl.setOrderTbMaster(null);

		return orderProductTbDtl;
	}

	public ProductsTbMaster getProductsTbMaster() {
		return this.productsTbMaster;
	}

	public void setProductsTbMaster(ProductsTbMaster productsTbMaster) {
		this.productsTbMaster = productsTbMaster;
	}

	public UserTbMaster getUserTbMaster() {
		return this.userTbMaster;
	}

	public void setUserTbMaster(UserTbMaster userTbMaster) {
		this.userTbMaster = userTbMaster;
	}

}