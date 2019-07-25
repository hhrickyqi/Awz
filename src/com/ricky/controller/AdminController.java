package com.ricky.controller;

import com.ricky.pojo.Category;
import com.ricky.pojo.Product;
import com.ricky.service.AdminService;
import com.ricky.service.CategoryService;
import com.ricky.utils.Page;
import com.ricky.vo.Condition;
import com.ricky.vo.PageBean;
import com.ricky.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private CategoryService categoryService;


    @RequestMapping("/home.do")
    public String getHome(){
        return "admin/home";
    }
    @RequestMapping("/top.do")
    public String getTop(){
        return "admin/top";
    }
    @RequestMapping("/left.do")
    public String getLeft(){
        return "admin/left";
    }
    @RequestMapping("/welcome.do")
    public String getWelcome(){
        return "admin/welcome";
    }
    @RequestMapping("/bottom.do")
    public String getBottom(){
        return "admin/bottom";
    }


    /*@RequestMapping("/list.do")
    public String getAllProduct(Model model , Condition condition){
        List<Product> productList = adminService.getAllProduct();
        List<Category> categoryList = categoryService.getAllCategory();
        model.addAttribute("productList" , productList);
        model.addAttribute("categoryList" , categoryList);
        model.addAttribute("condition" , condition);
        return "admin/product/list";
    }*/
    @RequestMapping("/list.do")
    public String getAllProduct(Model model , Condition condition ,QueryVo vo){
        List<Product> productList = adminService.getAllProduct();
        List<Category> categoryList = categoryService.getAllCategory();
        Page<Product> page = adminService.getPageByQueryVo(vo);
        model.addAttribute("page" , page);
        model.addAttribute("productList" , productList);
        model.addAttribute("categoryList" , categoryList);
        model.addAttribute("condition" , condition);
        return "admin/product/list";
    }

    @RequestMapping("/adminEditProduct.do")
    public String editProduct(Integer pid, Model model){
        Product product = adminService.getProductById(pid);
        model.addAttribute("product" , product);
        return "admin/product/edit";
    }

    @RequestMapping("/adminProductUpdate.do")
    @ResponseBody
    public void updateProduct(Product product){
        adminService.updateProduct(product);
    }

    @RequestMapping("/adminDeleteProduct.do")
    @ResponseBody
    public void deleteProduct(Integer pid){
        adminService.deleteProduct(pid);
    }

    @RequestMapping("/adminAddProduct.do")
    public String addProduct(Product product , Model model){
        adminService.addProduct(product);
        model.addAttribute("product" , product);
        return "admin/product/add";
    }

    @RequestMapping("/adminSearch.do")
    public String adminSearchWord(Model model , Condition condition){
        List<Product> productList = adminService.getProductsByCondition(condition);
        List<Category> categoryList = categoryService.getAllCategory();
        model.addAttribute("productList" , productList);
        model.addAttribute("categoryList" , categoryList);
        model.addAttribute("condition" , condition);
        return "admin/product/list";
    }


}
