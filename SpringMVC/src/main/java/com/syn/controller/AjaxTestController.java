package com.syn.controller;

import com.syn.dao.EmployeeDao;
import com.syn.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Collection;

@Controller
public class AjaxTestController {

    @Autowired
    EmployeeDao employeeDao;

    @ResponseBody
    @RequestMapping("/getallajax")
    public  Collection<Employee> ajaxGetAll(){
        Collection<Employee> all = employeeDao.getAll();
        return all;
    }


    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body){
        System.out.println(body);
        return "success";
    }


    @RequestMapping("/upload")
    public String upload(@RequestParam(value = "username") String username,
                         @RequestParam("headerimg") MultipartFile file,
                                 Model model)  {
        System.out.println("上传文件的信息"+file.getName());
        try {
            file.transferTo(Paths.get("D:\\360安全浏览器下载\\" + file.getOriginalFilename()));
            model.addAttribute("msg","文件上传成功");
        } catch (IOException e) {
            model.addAttribute("msg","文件上传失败");
            e.printStackTrace();
        }
        return "forward:/file.jsp";
    }
}
