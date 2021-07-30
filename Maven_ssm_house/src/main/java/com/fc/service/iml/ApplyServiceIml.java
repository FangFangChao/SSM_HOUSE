package com.fc.service.iml;

import com.fc.dao.ApplyMapper;
import com.fc.dao.CheckoutMapper;
import com.fc.pojo.Apply;
import com.fc.pojo.Checkout;
import com.fc.service.ApplyService;
import com.fc.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplyServiceIml implements ApplyService {
    @Autowired
    ApplyMapper applyMapper;


    @Override
    public List<Apply> findAllApply() {
        return applyMapper.findAllApply();
    }

    @Override
    public int deleteapply(String houseId) {
        return applyMapper.deleteapply(houseId);
    }

    @Override
    public int insertApply(String houseid, Integer id) {
        return applyMapper.insertApply(houseid, id);
    }

}
