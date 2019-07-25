package com.ricky.service;

import com.ricky.pojo.Product;
import com.ricky.vo.QueryVo;


import java.util.List;

public interface ProductService {


    List<Product> getAllProduct();

    int getProductTotal();

    List<Product> getProductsByQueryVo(QueryVo vo);

    List<Product> getProductsByWord(String word);
}
