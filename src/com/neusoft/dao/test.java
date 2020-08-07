package com.neusoft.dao;

import com.neusoft.dao.Impl.AdminDaoImpl;
import com.neusoft.domain.Business;
import com.neusoft.view.AdminView;
import com.neusoft.view.impl.AdminViewImpl;

import java.sql.SQLException;
import java.util.List;

public class test {
    public static void main(String[] args)throws SQLException {
        AdminView dao=new AdminViewImpl();
        List<Business> list=dao.setchaxun("饺子","沈阳");
        for(Business i:list){
            System.out.println(i);
        }
    }
}
