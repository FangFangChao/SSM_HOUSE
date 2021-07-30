package com.fc.service;

import com.fc.pojo.Paid;

import java.util.List;

public interface PaidService {

    List<Paid> showAddPaid();

    int addPaid(String houseId, String todate, String paydate, Integer userlistId, String status);
}
