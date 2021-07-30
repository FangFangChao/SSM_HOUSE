package com.fc.service.iml;

import com.fc.dao.ApplyoutMapper;
import com.fc.dao.WrongMapper;
import com.fc.pojo.Applyout;
import com.fc.pojo.Wrong;
import com.fc.service.ApplyoutService;
import com.fc.service.WrongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WrongServiceIml implements WrongService {
    @Autowired
    WrongMapper wrongMapper;

    @Override
    public List<Wrong> wrongList() {
        return wrongMapper.wrongList();
    }

    @Override
    public int updateWrong(String status, Integer id) {
        return wrongMapper.updateWrong(status, id);
    }

    @Override
    public int deleteWrong(Integer id) {
        return wrongMapper.deleteWrong(id);
    }

    @Override
    public Wrong selectWrong(Integer id) {
        return wrongMapper.selectByPrimaryKey(id);
    }
}
