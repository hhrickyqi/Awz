package com.ricky.controller;

import com.ricky.pojo.Category;
import com.ricky.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/categoryList.do")
    public String getAllCategory(Model model){
        List<Category> categoryList = categoryService.getAllCategory();
        model.addAttribute("categoryList" , categoryList);
        return "admin/product/add";
    }

}
