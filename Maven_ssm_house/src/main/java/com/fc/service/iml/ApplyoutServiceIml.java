package com.fc.service.iml;

import com.fc.dao.ApplyoutMapper;
import com.fc.pojo.Applyout;
import com.fc.service.ApplyoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplyoutServiceIml implements ApplyoutService {
    @Autowired
    ApplyoutMapper applyoutMapper;


    @Override
    public List<Applyout> findAllApplyout() {
        return applyoutMapper.findAllApplyout();
    }

    @Override
    public int deleteApplyout(String houseId) {
        return applyoutMapper.deleteApplyout(houseId);
    }

    @Override
    public int insertapplyout(Integer houseId, Integer id) {
        return applyoutMapper.insertapplyout(houseId, id);
    }
}
