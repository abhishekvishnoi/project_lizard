package com.learning.lizard.persistence;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the products_tb_master database table.
 * 
 */
@Entity
@Table(name="products_tb_master")
@NamedQuery(name="ProductsTbMaster.findAll", query="SELECT p FROM ProductsTbMaster p")
public class ProductsTbMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="product_id", unique=true, nullable=false)
	private int productId;

	@Temporal(TemporalType.DATE)
	@Column(name="date_added")
	private Date dateAdded;

	@Column(name="product_image", length=128)
	private String productImage;

	@Column(name="product_name", length=32)
	private String productName;

	@Column(name="product_price")
	private float productPrice;

	//bi-directional many-to-one association to OrderProductTbDtl
	@OneToMany(mappedBy="productsTbMaster")
	private List<OrderProductTbDtl> orderProductTbDtls;

	//bi-directional many-to-one association to OrderTbMaster
	@OneToMany(mappedBy="productsTbMaster")
	private List<OrderTbMaster> orderTbMasters;

	public ProductsTbMaster() {
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public Date getDateAdded() {
		return this.dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public String getProductImage() {
		return this.productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getProductPrice() {
		return this.productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	public List<OrderProductTbDtl> getOrderProductTbDtls() {
		return this.orderProductTbDtls;
	}

	public void setOrderProductTbDtls(List<OrderProductTbDtl> orderProductTbDtls) {
		this.orderProductTbDtls = orderProductTbDtls;
	}

	public OrderProductTbDtl addOrderProductTbDtl(OrderProductTbDtl orderProductTbDtl) {
		getOrderProductTbDtls().add(orderProductTbDtl);
		orderProductTbDtl.setProductsTbMaster(this);

		return orderProductTbDtl;
	}

	public OrderProductTbDtl removeOrderProductTbDtl(OrderProductTbDtl orderProductTbDtl) {
		getOrderProductTbDtls().remove(orderProductTbDtl);
		orderProductTbDtl.setProductsTbMaster(null);

		return orderProductTbDtl;
	}

	public List<OrderTbMaster> getOrderTbMasters() {
		return this.orderTbMasters;
	}

	public void setOrderTbMasters(List<OrderTbMaster> orderTbMasters) {
		this.orderTbMasters = orderTbMasters;
	}

	public OrderTbMaster addOrderTbMaster(OrderTbMaster orderTbMaster) {
		getOrderTbMasters().add(orderTbMaster);
		orderTbMaster.setProductsTbMaster(this);

		return orderTbMaster;
	}

	public OrderTbMaster removeOrderTbMaster(OrderTbMaster orderTbMaster) {
		getOrderTbMasters().remove(orderTbMaster);
		orderTbMaster.setProductsTbMaster(null);

		return orderTbMaster;
	}

}