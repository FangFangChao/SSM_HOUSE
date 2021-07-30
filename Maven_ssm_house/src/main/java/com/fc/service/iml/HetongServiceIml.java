package com.fc.service.iml;

import com.fc.dao.HetongMapper;
import com.fc.dao.UserMapper;
import com.fc.pojo.Hetong;
import com.fc.pojo.Houselist;
import com.fc.pojo.User;
import com.fc.service.HetongService;
import com.fc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HetongServiceIml implements HetongService {
    @Autowired
    private HetongMapper hetongMapper;

    @Override
    public Hetong showHeTong(String houseId) {
        return hetongMapper.showHeTong(houseId);
    }

    @Override
    public int deleteHeTong(String houseId) {
        return hetongMapper.deleteHeTong(houseId);
    }

    @Override
    public int updateHeTong(Hetong hetong1) {
        return hetongMapper.updateByPrimaryKey(hetong1);
    }

    @Override
    public Hetong toAddZuList(String houseId) {
        return hetongMapper.toAddZuList(houseId);
    }

    @Override
    public int addHeTong(Hetong hetong) {
        return hetongMapper.addHeTong(hetong);
    }


}
