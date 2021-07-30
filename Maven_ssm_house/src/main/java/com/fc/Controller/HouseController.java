package com.fc.Controller;

import com.fc.pojo.Houselist;
import com.fc.service.HouseListService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("house")
public class HouseController {
    @Autowired
    HouseListService houseListService;

    /*展示房源*/
    @RequestMapping("showHouseList")
    public ModelAndView showHouseList(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum) {
        PageHelper.startPage(pageNum, 3);
        List<Houselist> houseLists = houseListService.showHouseList();
        PageInfo<Houselist> info = new PageInfo<>(houseLists);
        ModelAndView mv = new ModelAndView();
        mv.addObject("houselists", info.getList());
        mv.addObject("p", info);
        mv.setViewName("./admin/ahouselist");
        return mv;
    }

    @RequestMapping("ahouselist.action")
    public ModelAndView ahouselist(Integer page) {
        return showHouseList(page);
    }

    /*跳转添加房源页面*/
    @RequestMapping("toaddhouse")
    public ModelAndView toaddhouse() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("./admin/addhouse");
        return mv;
    }

    /*添加房源*/
    @RequestMapping("addhouse")
    public ModelAndView addhouse(Houselist houselist) {
        int affectedRows = houseListService.insert(houselist);
        System.out.println("受影响的行数" + affectedRows);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:./showHouseList");
        return mv;
    }

    /*删除房源*/
    @RequestMapping("deleteHouse")
    public ModelAndView deleteByPrimaryKey(Houselist key) {
        int affectedRows = houseListService.deleteByPrimaryKey(key);
        System.out.println("受影响的行数" + affectedRows);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:./showHouseList");
        return mv;
    }

    /*跳转修改房源页面*/
    @RequestMapping("houseInfo")
    public ModelAndView houseInfo(Houselist record) {
        Houselist houseInfo = houseListService.getHouseInfo(record);
        ModelAndView mv = new ModelAndView();
        mv.addObject("houselist", houseInfo);
        mv.setViewName("./admin/changehouse");
        return mv;
    }

    /*修改房源信息*/
    @RequestMapping("houseUpdate")
    public ModelAndView updateByPrimaryKey(Houselist record) {
        int affectedRows = houseListService.updateByPrimaryKey(record);
        System.out.println("受影响的行数" + affectedRows);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:./showHouseList");
        return mv;
    }

    /*租客查看房源列表*/
    @RequestMapping("zkHouselist")
    public ModelAndView zkHouselist(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum) {
        PageHelper.startPage(pageNum, 5);
        List<Houselist> houselists = houseListService.showHouseList();
        PageInfo<Houselist> pageInfo = new PageInfo<>(houselists);
        ModelAndView mv = new ModelAndView("./zuke/houselist");
        mv.addObject("p", pageInfo);
        mv.addObject("houselist", houselists);
        return mv;
    }

    /*租客上一页下一页*/
    @RequestMapping("houselist.action")
    public ModelAndView houselist(Integer page) {
        return zkHouselist(page);
    }


}
