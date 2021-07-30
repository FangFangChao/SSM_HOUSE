package com.fc.service.iml;

import com.fc.dao.CheckoutMapper;
import com.fc.dao.ZulistMapper;
import com.fc.pojo.Checkout;
import com.fc.pojo.Zulist;
import com.fc.service.CheckService;
import com.fc.service.ZuListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckServiceIml implements CheckService {
    @Autowired
    CheckoutMapper checkoutMapper;

    @Override
    public List<Checkout> getAllCheckOut() {
        return checkoutMapper.getAllCheckOut();
    }

    @Override
    public int deleteCheckOut(Integer id) {
        return checkoutMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertCheckout(String houseId, Integer id) {
        return checkoutMapper.insertCheckout(houseId, id);
    }
}
