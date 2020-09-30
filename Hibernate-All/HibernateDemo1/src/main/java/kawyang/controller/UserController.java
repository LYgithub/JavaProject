package kawyang.controller;

import kawyang.dao.UserDao;
import kawyang.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author LiYang
 * @Project Name: HibernateDemo1
 * @Package Name: kawyang.controller
 * Created by MacBook Air on 2020/08/21.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/{id}")
    private ModelAndView getUser(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView();
        User byId = userDao.findById(id);
        modelAndView.addObject("user",byId);
        return modelAndView;
    }

    @Test
    private void getUserById(){
        System.out.println(userDao.findById(1).toString());
    }
}
