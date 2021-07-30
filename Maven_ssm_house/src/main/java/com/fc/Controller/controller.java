package com.fc.Controller;

import com.fc.pojo.User;
import com.fc.service.UserService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("user")
public class controller {
    @Autowired
    UserService userService;

    /*查询所有用户*/
    @RequestMapping("userList")
    public ModelAndView userList() {
        List<User> list = userService.userList();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("userlist");
        mv.addObject("list", list);
        return mv;
    }

    @RequestMapping("main")
    public ModelAndView main() {
        ModelAndView mv = new ModelAndView("./admin/main1");
        return mv;
    }

    /*判断登录账号*/
    @RequestMapping("logincheck.action")
    public String getUser(User user, HttpServletRequest request, HttpServletResponse response) {
        User booleanUser = userService.getUser(user);
        HttpSession session = request.getSession(true);
        if (user.getType().equals("admin")) {
            if (booleanUser != null && booleanUser.getType().equals("admin")) {
                session.setAttribute("user", user);
                session.setMaxInactiveInterval(60 * 60);
                String Id = session.getId();
                Cookie cookie = new Cookie("JSESSIONID", Id);
                cookie.setMaxAge(60 * 60);
                response.addCookie(cookie);
                return "redirect:./main";
            } else if (!user.getUsername().equals("admin")) {
                request.setAttribute("Usererror", "error");
                return "/login";
            } else {
                request.setAttribute("error", "error");
                return "/login";
            }
        } else if (user.getType().equals("zuke")) {
            if (booleanUser != null) {
                if (booleanUser.getUsername().equals("admin")) {
                    request.setAttribute("Usererror", "error");
                    return "/login";
                }
                session.setAttribute("user", user);
                session.setMaxInactiveInterval(60 * 60);
                String sessionId = session.getId();
                Cookie cookie = new Cookie("JSESSIONID", sessionId);
                cookie.setMaxAge(60 * 60);
                response.addCookie(cookie);
                return "/zuke/main";
            } else {
                request.setAttribute("error", "error");
                return "/login";
            }
        }
        request.setAttribute("error", "error");
        return "login";
    }

    /*登陆页面*/
    @RequestMapping("login")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }

    /*退出登录 回到登录页面*/
    @RequestMapping("logout")
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
        // 获取session，参数要使用false
        HttpSession session = request.getSession(false);
        //判断session是否为空
        if (session != null) {
            //不为空  销毁session对象
            session.invalidate();
            //根据JSESSIONID获取cookie
            Cookie cookie = new Cookie("JSESSIONID", session.getId());
            //设置cookie时间为0
            cookie.setMaxAge(0);
            //将cookie发送给浏览器
            response.addCookie(cookie);
        }
        ModelAndView mv = new ModelAndView("redirect:./login");
        return mv;
    }
}
