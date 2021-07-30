package com.fc.Controller;

import com.fc.pojo.Checkout;
import com.fc.service.CheckService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("check")
public class CheckController {
    @Autowired
    CheckService checkService;

    /*展示已退租列表*/
    @RequestMapping("getAllCheckOut")
    public ModelAndView getAllCheckOut(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum) {
        PageHelper.startPage(pageNum, 3);

        List<Checkout> checkout = checkService.getAllCheckOut();
        PageInfo<Checkout> pageInfo = new PageInfo<>(checkout);
        ModelAndView mv = new ModelAndView();
        mv.addObject("checkout", pageInfo.getList());
        mv.addObject("p", pageInfo);
        mv.setViewName("./admin/checkout");
        return mv;
    }

    /*删除已退租列表信息*/
    @RequestMapping("deleteCheckOut")
    public ModelAndView deleteCheckOut(Integer id) {
        checkService.deleteCheckOut(id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:./getAllCheckOut");
        return mv;
    }

    /*退租列表上一页 下一页*/
    @RequestMapping("houselist.action")
    public ModelAndView houselist(Integer page) {
        return getAllCheckOut(page);
    }
}
