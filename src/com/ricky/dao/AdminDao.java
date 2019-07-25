package com.ricky.dao;

import com.ricky.pojo.Product;
import com.ricky.utils.Page;
import com.ricky.vo.Condition;
import com.ricky.vo.QueryVo;

import java.util.List;

public interface AdminDao {

    List<Product> getAllProduct();

    void updateProduct(Product product);

    Product getProductById(Integer pid);

    void deleteProduct(Integer pid);

    void addProduct(Product product);

    List<Product> getProductsByWord(String word);

    List<Product> getProductsByCondition(Condition condition);

    int getProductTotal();

    List<Product> getProductByQueryVo(QueryVo vo);

    Page<Product> getPageByQueryVo(QueryVo vo);
}
