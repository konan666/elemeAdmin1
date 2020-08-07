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
        int sum=dao.setsc(10011);
        System.out.print(sum);


    }
}
