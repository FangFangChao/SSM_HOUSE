package com.fc.Controller;

import com.fc.pojo.Hetong;
import com.fc.pojo.Userlist;
import com.fc.pojo.Zulist;
import com.fc.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("hetong")
public class HetongController {
    @Autowired
    HetongService hetongService;
    @Autowired
    UserListService userListService;
    @Autowired
    ZuListService zuListService;
    @Autowired
    HouseListService houseListService;
    @Autowired
    ApplyService applyService;
    @Autowired
    CheckService checkService;

    /*展示合同*/
    @RequestMapping("showHeTong")
    public ModelAndView showHeTong(String houseId) {
        Hetong hetong = hetongService.showHeTong(houseId);
        ModelAndView mv = new ModelAndView("./admin/hetong");
        mv.addObject("hetong", hetong);
        return mv;
    }

    /*跳转修改合同页面*/
    @RequestMapping("toUpdateHeTong")
    public ModelAndView toUpdateHeTong(Hetong hetong1) {
        Hetong hetong = hetongService.showHeTong(hetong1.getHouseId());
        ModelAndView mv = new ModelAndView("./admin/updatehetong");
        mv.addObject("hetong", hetong);
        return mv;
    }

    /*修改合同*/
    @RequestMapping("updateHeTong")
    public ModelAndView updateHeTong(Hetong hetong) {
        int affitedRows = hetongService.updateHeTong(hetong);
        System.out.println(hetong.getHouselist().getAddress());
        System.out.println(hetong.getHouselist().getPrice());
        ModelAndView mv = new ModelAndView("redirect:../zu/toZuList");
        return mv;
    }

    /*删除合同*/
    @RequestMapping("deleteHeTong")
    public ModelAndView deleteHeTong(Hetong hetong) {
        //*添加到退租列表*/
        /*根据房屋id查询租客*/
        Hetong hetong1 = hetongService.showHeTong(hetong.getHouseId());
        /*根据租客查找相应的id*/
        Userlist userlist = userListService.selectNameId(hetong1.getZuke());
        /*通过租客id 和房屋id  进行添加退租列表*/
        int affectedRows3 = checkService.insertCheckout(hetong.getHouseId(), userlist.getId());
        System.out.println("退租信息" + affectedRows3);
        //*删除合同信息*//*
        int affectedRows = hetongService.deleteHeTong(hetong.getHouseId());
        System.out.println("删除合同" + affectedRows);
        //*删除在租信息*//*
        int affectedRows1 = zuListService.deleteZulist(hetong.getHouseId());
        System.out.println("删除在租列表" + affectedRows1);
        //*改变房屋状态*//*
        int affectedRows2 = houseListService.updateStatus("未租赁", hetong.getHouseId());
        System.out.println("修改房屋状态" + affectedRows2);

        ModelAndView mv = new ModelAndView("redirect:../zu/toZuList");
        return mv;

    }

    /*添加合同*/
    @RequestMapping("addHeTong")
    public ModelAndView addHeTong(Hetong hetong) {
        /*添加合同*/
        int affitedRows = hetongService.addHeTong(hetong);
        System.out.println("合同" + affitedRows);
        //*修改房屋状态*//
        int i = houseListService.updateStatus("已租赁", hetong.getHouseId());
        System.out.println("已租赁" + i);
        //*查询承租者的id*//
        Userlist userlist = userListService.selectNameId(hetong.getZuke());
        //*添加在租者的信息*//*
        int i1 = zuListService.insertZulist(hetong.getHouseId(), userlist.getId(), 5);
        System.out.println("添加在租信息" + i1);
        //*删除看房申请信息*//
        int i2 = applyService.deleteapply(hetong.getHouseId());
        System.out.println("删除申请信息" + i2);
        ModelAndView mv = new ModelAndView("redirect:../apply/findAllApply");
        return mv;
    }

    /*租客的查看租房合同*/
    @RequestMapping("zukeseehetong.action")
    public ModelAndView zukeseehetong(String houseId) {
        Hetong hetong = hetongService.showHeTong(houseId);
        ModelAndView mv = new ModelAndView("./zuke/showhetong");
        mv.addObject("hetong", hetong);
        return mv;
    }
}
