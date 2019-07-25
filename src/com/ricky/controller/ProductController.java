package com.ricky.controller;

import com.ricky.pojo.Product;
import com.ricky.service.ProductService;
import com.ricky.vo.PageBean;
import com.ricky.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/productList.do")
    public String getProductList(String currentPage ,Model model){
        /*List<Product> productList = productService.getAllProduct();
        model.addAttribute("productList" , productList);*/
        PageBean pageBean = new PageBean();
        if (null == currentPage ) currentPage = "1";
        int cp = Integer.valueOf(currentPage);
        pageBean.setCurrentPage(cp);
        int maxCount = 12;
        pageBean.setMaxCount(maxCount);
        pageBean.setTotalCount(productService.getProductTotal());
        pageBean.setTotalPages((int) Math.ceil(1.0*productService.getProductTotal()/maxCount));
        QueryVo vo = new QueryVo();
        vo.setStartIndex((cp - 1) * maxCount);
        vo.setMaxCount(maxCount);
        pageBean.setProductList(productService.getProductsByQueryVo(vo));
        model.addAttribute("pageBean" , pageBean);
        return "product_list";
    }

    @RequestMapping("/searchWord.do")
    @ResponseBody
    public List<Product> searchWord(String word){
        List<Product> productList = productService.getProductsByWord(word);
        return productList;
    }

    /*<li><a href="login.jsp">登录</a></li>
			<li><a href="register.jsp">注册</a></li>
			<li><a href="cart.jsp">购物车</a></li>
			<li><a href="order_list.jsp">我的订单</a></li>*/
    @RequestMapping("/login.do")
    public String loginPage(){
        return "login";
    }

    @RequestMapping("/register.do")
    public String registerPage(){
        return "register";
    }
    @RequestMapping("/cart.do")
    public String cartPage(){
        return "cart";
    }
    @RequestMapping("/order_list.do")
    public String orderList(){
        return "order_list";
    }
    @RequestMapping("/product_info.do")
    public String productIofo(){
        return "product_info";
    }



}
