package com.fc.Controller;

import com.fc.pojo.Apply;
import com.fc.pojo.Hetong;
import com.fc.pojo.Paid;
import com.fc.pojo.Zulist;
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
@RequestMapping("paid")
public class paidController {
    @Autowired
    PaidService paidService;
    @Autowired
    ZuListService zuListService;
    @Autowired
    HetongService hetongService;
    @Autowired
    TopaidService topaidService;

    /*我要收租*/
    @RequestMapping("showAddPaid")
    public ModelAndView showAddPaid(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum) {
        List<Zulist> zulists = zuListService.showZuList();
        PageHelper.startPage(pageNum, 5);
        PageInfo<Zulist> pageInfo = new PageInfo<>(zulists);
        ModelAndView mv = new ModelAndView("./admin/showaddpaid");
        mv.addObject("zulist", pageInfo.getList());
        mv.addObject("p", pageInfo);
        return mv;
    }

    /*收租上一页 下一页*/
    @RequestMapping("showaddpaid.action")
    public ModelAndView showaddpaid(Integer page) {
        return showAddPaid(page);
    }

    /*收租的操作*/
    @RequestMapping("addPaid")
    public ModelAndView addPaid(Integer zid) {
        //*根据id查询对应的在租信息*//*
        Zulist zulist = zuListService.selectZulist(zid);
        //*根据房屋id 查询合同租赁的日期*//*
        /*        Hetong hetong = hetongService.showHeTong(zulist.getHouseId());*/
        //*根据在租信息 添加收租已成功信息*//*
        /*        int affectedRows = paidService.addPaid(zulist.getHouseId(), hetong.getTodate(), hetong.getTodate(), zulist.getUserlistId(), "已缴纳");*/
        ModelAndView mv = new ModelAndView("./admin/addpaid");
        mv.addObject("zulist", zulist);
        return mv;
    }

    /*添加收租信息*/
    @RequestMapping("insertToPaid")
    public ModelAndView insertToPaid(Paid paid) {
        ModelAndView mv = new ModelAndView();
        ;
        Hetong hetong = hetongService.showHeTong(paid.getHouseId());
        int affectedRows = paidService.addPaid(paid.getHouseId(), paid.getDate(), paid.getDate(), paid.getUserlistId(), "已缴纳");
        System.out.println("已交租");
        /*删除对应日期的未缴纳信息*/

        return null;
    }


}
