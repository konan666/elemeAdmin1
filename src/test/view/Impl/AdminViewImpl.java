package test.view.Impl;

import test.Dao.AdminDao;
import test.Dao.Impl.AdminDaoImpl;
import test.view.AdminView;

import java.sql.SQLException;

public class AdminViewImpl implements AdminView{
    AdminDao dao=new AdminDaoImpl();
    public int getLogin(String adminName,String password) throws SQLException {
        int sum=dao.Login(adminName,password);
        return sum;
    }
}
