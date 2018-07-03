package com.dream.myLife.index;

import com.alibaba.druid.support.json.JSONUtils;
import com.dream.myLife.user.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhang on 2018/1/28.
 */
@Controller
public class IndexController {
    @Autowired
    private IUserService userService;

    @RequestMapping(value = {"/","/index.html","/login"})
    public ModelAndView loginPage(HttpServletRequest request, Model model){
        userService.test();
        model.addAttribute("base",request.getContextPath());
        return new ModelAndView("index");
    }

    @RequestMapping(value = "testVue")
    public ModelAndView testVue(HttpServletRequest request, Model model){
        model.addAttribute("base",request.getContextPath());
        return new ModelAndView("testVue");
    }

    //跳转到登录页面
    @RequestMapping("/login.jhtml")
    public ModelAndView login() throws Exception {
        ModelAndView mav = new ModelAndView("login");
        return mav;
    }

    //跳转到登录页面
    @RequestMapping(value ={"/error.html","/error"})
    public ModelAndView myError() throws Exception {
        ModelAndView mav = new ModelAndView("403");
        return mav;
    }

    //跳转到登录成功页面
    @RequestMapping("/loginsuccess.html")
    public ModelAndView loginsuccess() throws Exception {
        ModelAndView mav = new ModelAndView("loginsuccess");
        return mav;
    }

    /**
     * 验证用户名和密码
     * @param String username,String password
     * @return
     */
    @RequestMapping(value="/checkLogin.json",method= RequestMethod.POST)
    @ResponseBody
    public String checkLogin(String username, String password, HttpServletRequest request) {
        Map<String, Object> result = new HashMap<String, Object>();
        try{
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            Subject currentUser = SecurityUtils.getSubject();
            if (!currentUser.isAuthenticated()){
                //使用shiro来验证
//                token.setRememberMe(true);
                currentUser.login(token);//验证角色和权限
            }
        }catch(Exception ex){
            throw new RuntimeException("登陆失败");
        }
        result.put("success", true);
        return JSONUtils.toJSONString(result);
    }
}
