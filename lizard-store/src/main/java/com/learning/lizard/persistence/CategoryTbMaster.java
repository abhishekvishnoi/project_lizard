package com.learning.lizard.persistence;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the category_tb_master database table.
 * 
 */
@Entity
@Table(name="category_tb_master")
@NamedQuery(name="CategoryTbMaster.findAll", query="SELECT c FROM CategoryTbMaster c")
public class CategoryTbMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="category_id", unique=true, nullable=false)
	private int categoryId;

	@Column(name="category_name", length=32)
	private String categoryName;

	@Temporal(TemporalType.DATE)
	@Column(name="date_added")
	private Date dateAdded;

	public CategoryTbMaster() {
	}

	public int getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Date getDateAdded() {
		return this.dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

}