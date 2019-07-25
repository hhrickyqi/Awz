package com.ricky.service;

import com.ricky.dao.AdminDao;
import com.ricky.pojo.Product;
import com.ricky.utils.Page;
import com.ricky.vo.Condition;
import com.ricky.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminDao adminDao;
    @Override
    public List<Product> getAllProduct() {
        return adminDao.getAllProduct();
    }

    @Override
    public void updateProduct(Product product) {
        adminDao.updateProduct(product);
    }

    @Override
    public Product getProductById(Integer pid) {
        return adminDao.getProductById(pid);
    }

    @Override
    public void deleteProduct(Integer pid) {
        adminDao.deleteProduct(pid);
    }

    @Override
    public void addProduct(Product product) {
        adminDao.addProduct(product);
    }

    @Override
    public List<Product> getProductsByWord(String word) {
        return adminDao.getProductsByWord(word);
    }

    @Override
    public List<Product> getProductsByCondition(Condition condition) {
        return adminDao.getProductsByCondition(condition);
    }

    @Override
    public int getProductTotal() {
        return adminDao.getProductTotal();
    }

    @Override
    public List<Product> getProductByQueryVo(QueryVo vo) {
        return adminDao.getProductByQueryVo(vo);
    }

    @Override
    public Page<Product> getPageByQueryVo(QueryVo vo) {
        Page<Product> page = new Page<>();
        if(null != vo){
            vo.setMaxCount(6);
            if (null != vo.getPage( ) && !vo.getPage().equals("")){
                page.setPage(Integer.valueOf(vo.getPage()));
                vo.setStartIndex((Integer.valueOf(vo.getPage()) - 1) *vo.getMaxCount());
            }
            page.setSize(5);
            //page.setTotal(adminDao.getProductTotal(vo));
           //page.setRows(adminDao.getProductList(vo));
        }
        return page;
    }

}
