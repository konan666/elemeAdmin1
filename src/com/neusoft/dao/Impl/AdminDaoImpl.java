package com.neusoft.dao.Impl;

import com.mysql.jdbc.JDBC4Connection;
import com.neusoft.dao.AdminDao;
import com.neusoft.domain.Admin;
import com.neusoft.domain.Business;
import com.neusoft.utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Eric Lee
 * @date 2020/8/7 09:48
 */
public class AdminDaoImpl implements AdminDao {
    private  Connection conn =null;
    private PreparedStatement pstmt =null;
    private ResultSet rs =null;


    @Override
    public Admin getAdminByNameByPass(String adminName, String password) {
        Admin admin = null;
        String sql = "select * from admin where adminName = ? and password = ?";
        try{
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, adminName);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            while (rs.next()){
                admin = new Admin();
                admin.setAdminId(rs.getInt("adminId"));
                admin.setAdminName(rs.getString("adminName"));
                admin.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs, pstmt, conn);
        }

        return admin;
    }

    @Override
    public List<Business> getSelect() {
        List list=new ArrayList();
        String sql="select * from business";
        try{
     conn= JDBCUtils.getConnection();
     pstmt=conn.prepareStatement(sql);
     rs=pstmt.executeQuery();
     while (rs.next()){
         Business business=new Business();
         business.setBusinessId(rs.getInt(1));
         business.setPawword(rs.getString(2));
         business.setBusinessName(rs.getString(3));
         business.setBusinessAddress(rs.getString(4));
         business.setBusinessExplain(rs.getString(5));
         business.setStarPrice(rs.getDouble(6));
         business.setDeliveryPrice(rs.getDouble(7));
         list.add(business);
     }



        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    public List<Business> aaacs(String businessName,String businessAddress){
        List<Business> list1=new ArrayList();
        System.out.println(businessName+businessAddress);
        StringBuffer sql = new StringBuffer("select * from business where 1=1 ");
        if(businessName!=null && !businessName.equals("")) {
            sql.append("and businessName like '%"+businessName+"%'");
        }
        if(businessAddress!=null && !businessAddress.equals("")) {
            sql.append("and businessAddress like '%"+businessAddress+"%'");
        }
        try{
            conn= JDBCUtils.getConnection();
            pstmt=conn.prepareStatement(sql.toString());
            rs=pstmt.executeQuery();
            while(rs.next()){
                Business business=new Business();
                business.setBusinessId(rs.getInt(1));
                business.setPawword(rs.getString(2));
                business.setBusinessName(rs.getString(3));
                business.setBusinessAddress(rs.getString(4));
                business.setBusinessExplain(rs.getString(5));
                business.setStarPrice(rs.getDouble(6));
                business.setDeliveryPrice(rs.getDouble(7));
                list1.add(business);
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,pstmt,conn);
        }
        return list1;
}
}
