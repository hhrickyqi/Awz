package com.ricky.dao;

import com.ricky.pojo.Product;
import com.ricky.vo.QueryVo;

import java.util.List;

public interface ProductDao {
    List<Product> getAllProduct();

    int getProductTotal();

    List<Product> getProductsByQueryVo(QueryVo vo);

    List<Product> getProductsByWord(String word);
}
