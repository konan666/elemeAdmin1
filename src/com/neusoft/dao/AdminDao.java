package com.neusoft.dao;

import com.neusoft.domain.Admin;
import com.neusoft.domain.Business;

import java.sql.SQLException;
import java.util.List;

public interface AdminDao {
    public Admin getAdminByNameByPass(String adminName, String password);
    public List<Business> getSelect();
    public List<Business> aaacs(String businessName,String businessAddress);
    public int aaacr(String businessName) throws SQLException;
    public int aaasc(int businessId) throws SQLException;
}
