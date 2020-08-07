package com.neusoft.dao;

import com.neusoft.domain.Admin;
import com.neusoft.domain.Business;

import java.util.List;

public interface AdminDao {
    public Admin getAdminByNameByPass(String adminName, String password);
    public List<Business> getSelect();
    public List<Business> aaacs(String businessName,String businessAddress);
}
