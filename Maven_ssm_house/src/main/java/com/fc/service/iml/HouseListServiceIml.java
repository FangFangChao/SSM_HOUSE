package com.fc.service.iml;

import com.fc.dao.HouselistMapper;
import com.fc.dao.UserlistMapper;
import com.fc.pojo.Houselist;
import com.fc.pojo.Userlist;
import com.fc.service.HouseListService;
import com.fc.service.UserListService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseListServiceIml implements HouseListService {
    @Autowired
    HouselistMapper houselistMapper;

    /*查询全部房源*/
    @Override
    public List<Houselist> showHouseList() {
        return houselistMapper.showHouseList();
    }

    /*添加房源*/
    @Override
    public int insert(Houselist record) {
        return houselistMapper.insert(record);
    }

    /*删除房源*/
    @Override
    public int deleteByPrimaryKey(Houselist key) {
        return houselistMapper.deleteByPrimaryKey(key);
    }

    /*修改房源*/
    @Override
    public int updateByPrimaryKey(Houselist record) {
        return houselistMapper.updateByPrimaryKey(record);
    }

    @Override
    public Houselist getHouseInfo(Houselist record) {
        return houselistMapper.selectByPrimaryKey(record);
    }

    @Override
    public int updateStatus(String status, String houseid) {
        return houselistMapper.updateStatus(status, houseid);
    }

    @Override
    public Houselist selectByprimary(Integer id) {
        return houselistMapper.selectByprimary(id);
    }
}

