package konan.view.Impl;

import konan.dao.AdminDao;
import konan.dao.Impl.AdminDaoImpl;
import konan.view.AdminView;

import java.sql.SQLException;

public class AdminViewImpl implements AdminView {
    @Override
    public int login(String adminName, String password) throws SQLException {
        AdminDao dao=new AdminDaoImpl();
        int sum=dao.finall(adminName,password);
        return sum;
    }
}
