package com.fc.service.iml;

import com.fc.dao.ApplyoutMapper;
import com.fc.dao.TopaidMapper;
import com.fc.pojo.Applyout;
import com.fc.pojo.Topaid;
import com.fc.service.ApplyoutService;
import com.fc.service.TopaidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopaidServiceIml implements TopaidService {
    @Autowired
    TopaidMapper topaidMapper;

    @Override
    public List<Topaid> toPaidList() {
        return topaidMapper.toPaidList();
    }
}
