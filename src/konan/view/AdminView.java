package konan.view;

import java.sql.SQLException;

public interface AdminView {
    public int login(String adminName,String password) throws SQLException;
}
