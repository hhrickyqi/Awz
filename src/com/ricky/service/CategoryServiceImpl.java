package com.ricky.service;

import com.ricky.dao.CategoryDao;
import com.ricky.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;
    @Override
    public List<Category> getAllCategory() {
        return categoryDao.getAllCategory();
    }
}
