package com.learning.lizard.persistence;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the user_tb_master database table.
 * 
 */
@Entity
@Table(name="user_tb_master")
@NamedQuery(name="UserTbMaster.findAll", query="SELECT u FROM UserTbMaster u")
public class UserTbMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id", unique=true, nullable=false)
	private int userId;

	@Temporal(TemporalType.DATE)
	@Column(name="date_added")
	private Date dateAdded;

	@Column(name="user_email", length=64)
	private String userEmail;

	@Column(name="user_name", length=32)
	private String userName;

	@Column(name="user_password", length=32)
	private String userPassword;

	@Column(name="user_role", nullable=false)
	private int userRole;

	//bi-directional many-to-one association to OrderTbMaster
	@OneToMany(mappedBy="userTbMaster")
	private List<OrderTbMaster> orderTbMasters;

	public UserTbMaster() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getDateAdded() {
		return this.dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public int getUserRole() {
		return this.userRole;
	}

	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}

	public List<OrderTbMaster> getOrderTbMasters() {
		return this.orderTbMasters;
	}

	public void setOrderTbMasters(List<OrderTbMaster> orderTbMasters) {
		this.orderTbMasters = orderTbMasters;
	}

	public OrderTbMaster addOrderTbMaster(OrderTbMaster orderTbMaster) {
		getOrderTbMasters().add(orderTbMaster);
		orderTbMaster.setUserTbMaster(this);

		return orderTbMaster;
	}

	public OrderTbMaster removeOrderTbMaster(OrderTbMaster orderTbMaster) {
		getOrderTbMasters().remove(orderTbMaster);
		orderTbMaster.setUserTbMaster(null);

		return orderTbMaster;
	}

}