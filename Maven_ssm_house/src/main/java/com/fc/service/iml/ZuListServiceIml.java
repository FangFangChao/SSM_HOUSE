package com.fc.service.iml;

import com.fc.dao.HouselistMapper;
import com.fc.dao.ZulistMapper;
import com.fc.pojo.Houselist;
import com.fc.pojo.Zulist;
import com.fc.service.ZuListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZuListServiceIml implements ZuListService {
    @Autowired
    ZulistMapper zulistMapper;

    @Override
    public List<Zulist> showZuList() {
        return zulistMapper.showZuList();
    }

    @Override
    public int insertZulist(String houseId, Integer userlistId, int contractId) {
        return zulistMapper.insertZulist(houseId, userlistId, contractId);
    }

    @Override
    public int deleteZulist(String houseId) {
        return zulistMapper.deleteZulist(houseId);
    }

    @Override
    public Zulist selectZulist(Integer zid) {
        return zulistMapper.selectZulist(zid);
    }

}
