package com.fc.service;

import com.fc.pojo.Checkout;
import com.fc.pojo.Hetong;

import java.util.List;

public interface CheckService {
    List<Checkout> getAllCheckOut();

    int deleteCheckOut(Integer id);

    int insertCheckout(String houseId, Integer id);
}
