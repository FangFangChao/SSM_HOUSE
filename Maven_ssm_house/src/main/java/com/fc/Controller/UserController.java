package com.fc.Controller;

import com.fc.pojo.User;
import com.fc.pojo.Userlist;
import com.fc.service.UserListService;
import com.fc.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserListService userListService;

    @RequestMapping("findAllUserList")
    public ModelAndView findAllUserList(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum) {
        PageHelper.startPage(pageNum, 2);
        List<Userlist> userList = userListService.getUserList();
        PageInfo<Userlist> PageInfo = new PageInfo<>(userList);
        ModelAndView mv = new ModelAndView("/admin/userlist");
        mv.addObject("userlist", PageInfo.getList());
        mv.addObject("p", PageInfo);
        return mv;

    }

    @RequestMapping("findalluserlist.action")
    public ModelAndView findalluserlist(Integer page) {
        return findAllUserList(page);

    }


}
