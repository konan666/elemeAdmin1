package konan.dao;

import konan.domain.Admin;

import java.sql.SQLException;
import java.util.List;

public interface AdminDao {
    public int finall(String adminName,String password) throws SQLException;
}
