package test.Dao;

import java.sql.SQLException;

public interface AdminDao {
    public int Login(String adminName,String password) throws SQLException;
}
