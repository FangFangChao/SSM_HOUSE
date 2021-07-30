package com.fc.Controller;

import com.fc.pojo.Apply;
import com.fc.pojo.Solve;
import com.fc.pojo.Wrong;
import com.fc.service.ApplyService;
import com.fc.service.SolveService;
import com.fc.service.WrongService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("wrong")
public class WrongController {
    /*展示待处理保障*/
    @Autowired
    WrongService wrongService;
    @Autowired
    SolveService solveService;

    @RequestMapping("wrongList")
    public ModelAndView wrongList(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum) {
        List<Wrong> wrong = wrongService.wrongList();
        PageHelper.startPage(pageNum, 5);
        PageInfo<Wrong> PageInfo = new PageInfo<>(wrong);
        ModelAndView mv = new ModelAndView("./admin/wrong");
        mv.addObject("wrong", PageInfo.getList());
        mv.addObject("p", PageInfo);
        return mv;
    }

    /*上一页 下一页*/
    @RequestMapping("wronglist.action")
    public ModelAndView wronglist(Integer page) {
        return wrongList(page);
    }

    /*已处理保障*/
    @RequestMapping("goToSolve")
    public ModelAndView goToSolve(Integer id) {
        /*改变已处理*/
        int affectedRows = wrongService.updateWrong("已处理", id);
        System.out.println("处理成功" + affectedRows);
        /*并且添加到已处理故障列表*/
        /*先根据id查询到故障对象*/
        Wrong wrong = wrongService.selectWrong(id);
        /*已经处理的对象属性 对添加已处理保障进行赋值*/
        int affectedRows1 = solveService.insertSolve(wrong.getHouseId(), wrong.getDate(), wrong.getDetail(), wrong.getUserlistId(), wrong.getStatus());
        System.out.println("添加成功" + affectedRows1);
        /*删除故障问题 */
        int affectedRows2 = wrongService.deleteWrong(id);
        System.out.println("删除故障问题" + affectedRows2);
        ModelAndView mv = new ModelAndView("redirect:./wrongList");

        return mv;
    }

    /*已处理保障*/
    @RequestMapping("selectAll")
    public ModelAndView selectAll(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum, String zuname, String fromdate, String todate) {
        List<Solve> solves = solveService.selectAllSubmit(zuname, fromdate, todate);
        PageHelper.startPage(pageNum, 10);
        PageInfo<Solve> solvePageInfo = new PageInfo<>(solves);
        ModelAndView mv = new ModelAndView("./admin/solve");
        mv.addObject("solve", solvePageInfo.getList());
        mv.addObject("p", solvePageInfo);
        mv.addObject("count", solves.size());
        return mv;
    }

    /*删除已处理故障*/
    @RequestMapping("deleteSolve")
    public ModelAndView deleteSolve(Integer id) {
        int affectedRows = solveService.deleteSolve(id);
        System.out.println("删除已处理故障" + affectedRows);
        ModelAndView mv = new ModelAndView("redirect:./selectAll");
        return mv;
    }

}