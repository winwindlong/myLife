package com.dream.myLife.user;


import com.dream.myLife.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by zhang on 2018/1/18.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @RequestMapping(value = "index.html")
    public ModelAndView portalLogin(Model model){
        userService.test();
        return new ModelAndView("index");
    }
}
