package com.fc.service.iml;

import com.fc.dao.PaidMapper;
import com.fc.pojo.Paid;
import com.fc.service.PaidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaidServiceIml implements PaidService {
    @Autowired
    PaidMapper paidMapper;


    @Override
    public List<Paid> showAddPaid() {
        return null;
    }

    @Override
    public int addPaid(String houseId, String todate, String paydate, Integer userlistId, String status) {
        return paidMapper.addPaid(houseId, todate, paydate, userlistId, status);
    }
}
