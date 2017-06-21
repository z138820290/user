package com.hzy.demo.controller;

import com.hzy.demo.domain.User;
import com.hzy.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by 何峥言 on 2017/6/16.
 */
@Controller
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 跳转到首页
     * @param model
     * @return 跳转到首页
     */
    @GetMapping
    public String toUserIndex(Model model, HttpServletRequest request){
        int count=userService.getUserCount();
        int pageSize=10;
        int pageNumber=0;
        if (request.getParameter("page")!=null){
           pageNumber=Integer.parseInt(request.getParameter("page"));
        }
        List counts=new ArrayList();
        int i=0;
        while(true){
            i++;
            counts.add(i);
            if (i==count/10+1){
                break;
            }
        }
        if (count%10==0){
            int index=counts.size()-1;
            counts.remove(index);
        }
        List<User> users = userService.getAllUsers(pageNumber,pageSize);
        model.addAttribute("users",users);
        model.addAttribute("counts",counts);
        return "user/index";
    }

    @GetMapping("/{id}")/*/user/1*/
    public String toUserModify(@PathVariable int id, Model model){
        User user=userService.getUserById(id);
        model.addAttribute("user",user);
        return "user/modify";
    }
    @PutMapping("/{id}")/* /user/1 */
    @ResponseBody
    public String modifyUser(@PathVariable int id, @RequestBody User user){
        user.setId(id);
        if (userService.modifyUserById(user)){
            return "user";
        }
        return "user/modify/"+id;
    }

    @GetMapping("/new")
    public String toNew(){
        return "user/new";
    }

    @PostMapping("/addUser")
    @ResponseBody
    public String addUser(@RequestBody User user){
        userService.addUser(user);
        return "user";
    }

    @DeleteMapping("/delete") /* /user/1 */
    @ResponseBody
    public String deleteUser(@RequestBody String[] str){
        for (int i=0;i<str.length;i++){
            int id=Integer.parseInt(str[i]);
            userService.deleteUserById(id);
        }
        return "redirect:/user";
    }

}
