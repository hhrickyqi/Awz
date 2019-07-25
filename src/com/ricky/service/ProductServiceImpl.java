package com.ricky.service;

import com.ricky.dao.ProductDao;
import com.ricky.pojo.Product;
import com.ricky.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;


    @Override
    public List<Product> getAllProduct() {
        return productDao.getAllProduct();
    }

    @Override
    public int getProductTotal() {
        return productDao.getProductTotal();
    }

    @Override
    public List<Product> getProductsByQueryVo(QueryVo vo) {
        return productDao.getProductsByQueryVo(vo);
    }

    @Override
    public List<Product> getProductsByWord(String word) {
        return productDao.getProductsByWord(word);
    }
}
