package com.fc.Controller;

import com.fc.pojo.User;
import com.fc.pojo.Userlist;
import com.fc.service.UserListService;
import com.fc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller

public class UserfindHas {
    @Autowired
    UserListService userListService;
    @Autowired
    UserService userService;

    @RequestMapping("findHasUserList")
    public ModelAndView findHasUserList(HttpSession session) {
        /*获取登陆账号*/
        User user = (User) session.getAttribute("user");
        System.out.println(user.getUsername());
        /*查询账号id*/
        User user1 = userService.selectIdName(user.getUsername());
        System.out.println(user1.getId());
        Userlist userlist1 = userListService.selectUserlist(user1.getId());
        ModelAndView mv = new ModelAndView("./zuke/updateuserlist");
        mv.addObject("userlist", userlist1);
        return mv;
    }

    /*修改账号绑定信息*/
    @RequestMapping("checkUserList")
    public ModelAndView checkUserList(Userlist userlist) {
        int affectedRows = userListService.updateUserList(userlist);
        System.out.println("修改账户信息" + affectedRows);
        ModelAndView mv = new ModelAndView("./zuke/main");
        return mv;
    }
}
