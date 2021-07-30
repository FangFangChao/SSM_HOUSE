package com.fc.Controller;

import com.fc.pojo.*;
import com.fc.service.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("apply")
public class applyController {
    @Autowired
    ApplyService applyService;
    @Autowired
    HouseListService houseListService;
    @Autowired
    UserService userService;
    @Autowired
    UserListService userListService;

    /*展示所有申请看房列表*/
    @RequestMapping("findAllApply")
    public ModelAndView findAllApply(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum) {
        List<Apply> allApply = applyService.findAllApply();
        PageHelper.startPage(pageNum, 3);
        PageInfo<Apply> applyPageInfo = new PageInfo<>(allApply);
        ModelAndView mv = new ModelAndView("./admin/applylist");
        mv.addObject("applylist", applyPageInfo.getList());
        mv.addObject("p", applyPageInfo);
        return mv;
    }

    /*申请看房上一页下一页*/
    @RequestMapping("houselist.action")
    public ModelAndView houselist(Integer page) {
        return findAllApply(page);
    }

    /*根据id 拒绝看房时 删除申请信息*/
    @RequestMapping("reFuseApply")
    public ModelAndView reFuseApply(String houseId) {
        int affited = applyService.deleteapply(houseId);
        ModelAndView mv = new ModelAndView("redirect:./findAllApply");
        return mv;
    }
    /*租客进行租房申请*/

    @RequestMapping("applyCheckUserList")
    public ModelAndView applyCheckUserList(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum, Integer id, HttpSession session) {
        /*获取用户名*/
        User user = (User) session.getAttribute("user");
        /*根据用户名查找相应的id*/
        User user1 = userService.selectIdName(user.getUsername());
        /*根据用户名id 查找租客的id*/
        Userlist userlist = userListService.selectUserlist(user1.getId());
        /*根据前端传过来的id 查找响应的房屋id*/
        Houselist houselist = houseListService.selectByprimary(id);
        /*添加申请租赁信息*/
        int affectedRows = applyService.insertApply(houselist.getHouseid(), userlist.getId());
        /*改变申请房屋状态*/
        houseListService.updateStatus("申请中", houselist.getHouseid());
        System.out.println("申请加" + affectedRows);
        ModelAndView mv = new ModelAndView("redirect:../house/zkHouselist");
        return mv;
    }

}
