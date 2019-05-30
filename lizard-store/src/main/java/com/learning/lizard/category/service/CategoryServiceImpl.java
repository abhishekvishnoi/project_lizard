package com.learning.lizard.category.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learning.lizard.dao.GenericDAO;
import com.learning.lizard.persistence.CategoryTbMaster;


@Service
public class CategoryServiceImpl implements CategoryService {
	
	private GenericDAO<CategoryTbMaster> dao;

	@Autowired
	public void setDAO(GenericDAO<CategoryTbMaster> daoToSet) {
		dao = daoToSet;
		dao.setClazz(CategoryTbMaster.class);
	}

	@Override
	@Transactional
	public List<CategoryTbMaster> findAllCategory() {
		
		List<CategoryTbMaster> entityList = dao.findAll();
		
		return entityList;
	}

}
