package com.fc.Controller;

import com.fc.pojo.*;
import com.fc.service.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("zu")
public class ZulistController {
    /*在租列表*/
    @Autowired
    ZuListService zuListService;
    @Autowired
    HetongService hetongService;
    @Autowired
    UserListService userListService;

    @RequestMapping("toZuList")
    public ModelAndView toZuList(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum) {
        PageHelper.startPage(pageNum, 3);
        List<Zulist> zuList = zuListService.showZuList();
        PageInfo<Zulist> info = new PageInfo<>(zuList);
        ModelAndView mv = new ModelAndView("./admin/zulist");
        mv.addObject("zulist", info.getList());
        mv.addObject("p", info);
        return mv;

    }

    /*在租列表下一页上一页*/
    @RequestMapping("findzulist.action")
    public ModelAndView findzulist(Integer page) {
        return toZuList(page);

    }

    /*跳转签订合同页面*/
    @RequestMapping("toAddZuList")
    public ModelAndView toAddZuList(Hetong hetong) {
        Hetong hetong1 = hetongService.toAddZuList(hetong.getHouseId());
        ModelAndView mv = new ModelAndView("./admin/addhetong");
        mv.addObject("hetong", hetong1);
        mv.addObject("houseId", hetong.getHouseId());
        return mv;
    }

    /*租客的看房申请列表*/
    @RequestMapping("getMyApply")
    public ModelAndView getMyApply(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum) {
        List<Userlist> userList = userListService.getUserListApply();
        PageHelper.startPage(pageNum, 3);
        PageInfo<Userlist> PageInfo = new PageInfo<>(userList);
        ModelAndView mv = new ModelAndView("./zuke/myapply");
        mv.addObject("userlist", userList);
        mv.addObject("p", PageInfo);
        return mv;
    }

    /*每个租客的在租列表*/
    @RequestMapping("myZuList")
    public ModelAndView myZuList() {
        List<Userlist> userList = userListService.myZuList();
        ModelAndView mv = new ModelAndView("./zuke/myzulist");
        mv.addObject("userlistzu", userList);
        return mv;

    }
}
