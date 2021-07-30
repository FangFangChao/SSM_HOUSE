package com.fc.Controller;

import com.fc.pojo.Apply;
import com.fc.pojo.Applyout;
import com.fc.pojo.Hetong;
import com.fc.pojo.Userlist;
import com.fc.service.*;
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
@RequestMapping("applyout")
public class applyoutController {
    @Autowired
    ApplyoutService applyoutService;
    @Autowired
    ZuListService zuListService;
    @Autowired
    HouseListService houseListService;
    @Autowired
    CheckService checkService;
    @Autowired
    HetongService hetongService;
    @Autowired
    UserListService userListService;

    /*展示所有申请退房列表*/
    @RequestMapping("findAllApplyOut")
    public ModelAndView findAllApplyOut(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum) {
        List<Applyout> applyoutList = applyoutService.findAllApplyout();
        PageHelper.startPage(pageNum, 3);
        PageInfo<Applyout> applyPageInfo = new PageInfo<>(applyoutList);
        ModelAndView mv = new ModelAndView("./admin/applyout");
        mv.addObject("applyout", applyPageInfo.getList());
        mv.addObject("p", applyPageInfo);
        return mv;
    }

    /*申请退房上一页下一页*/
    @RequestMapping("findallapplyout.action")
    public ModelAndView houselist(Integer page) {

        return findAllApplyOut(page);
    }

    /*同意退租申请*/
    @RequestMapping("agreeApplyOut")
    public ModelAndView agreeApplyOut(String houseId) {
        //*修改房屋状态 为未租赁*//*
        int affectedRows = houseListService.updateStatus("未租赁", houseId);
        System.out.println("修改房屋状态" + affectedRows);
        //*删除在租信息*//*
        int affectedRows1 = zuListService.deleteZulist(houseId);
        System.out.println("删除在租信息" + affectedRows1);
        /*删除退租申请信息*/
        int affectedRows2 = applyoutService.deleteApplyout(houseId);
        System.out.println("删除退租信息" + affectedRows2);
        /*添加已退租信息*/
        /*查询租客*/
        Hetong hetong = hetongService.showHeTong(houseId);
        /*查询租客的id*/
        Userlist userlist = userListService.selectNameId(hetong.getZuke());
        /*添加已退租信息*/
        int affectedRows3 = checkService.insertCheckout(houseId, userlist.getId());
        System.out.println("退租信息" + affectedRows3);
        /*删除合同*/
        int affectedRows4 = hetongService.deleteHeTong(houseId);
        System.out.println("删除合同" + affectedRows4);
        ModelAndView mv = new ModelAndView("redirect:./findAllApplyOut");
        return mv;

    }

    /*拒绝退租申请*/
    @RequestMapping("refuseApplyout")
    public ModelAndView refuseApplyout(String houseId) {
        /*删除退租信息*/
        int affectedRows = applyoutService.deleteApplyout(houseId);
        System.out.println("删除退租信息" + affectedRows);
        ModelAndView mv = new ModelAndView("redirect:./findAllApplyOut");
        return mv;
    }

    /*租客申请退租*/
    @RequestMapping("insertapplyout.action")
    public ModelAndView insertapplyout(String houseId) {
        Integer houseid = Integer.valueOf(houseId);
        /*根据房屋id查询租客*/
        Hetong hetong = hetongService.showHeTong(houseId);
//        /*根据租客查询对应的id*/
        Userlist userlist = userListService.selectNameId(hetong.getZuke());
        /*添加退租申请*/
        int insertapplyout = applyoutService.insertapplyout(houseid, userlist.getId());
        /*修改房屋状态*/
        int affectedRows = houseListService.updateStatus("申请退租中", hetong.getHouseId());
        System.out.println("退租申请" + insertapplyout);
        System.out.println("状态" + affectedRows);
        /*删除*/
        ModelAndView mv = new ModelAndView("redirect:../zu/myZuList");
        mv.addObject("param.error", "applysuccess");
        return mv;
    }
}
