package com.itcast.controller;

import com.itcast.domain.Product;
import com.itcast.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @RequestMapping("/findAll.do")
    @RolesAllowed("ADMIN")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> ps = productService.findAll();
        mv.addObject("productList",ps);
        mv.setViewName("product-list");
        System.out.println(ps);
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Product product) throws Exception {
        System.out.println("save");
        System.out.println(product);
        productService.save(product);
        return "redirect:findAll.do";
    }

    @RequestMapping("/showAdd.do")
    public String showAdd(Product product) throws Exception {
        return "product-add";
    }
}
