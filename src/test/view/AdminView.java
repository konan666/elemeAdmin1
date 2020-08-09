package test.view;

import java.sql.SQLException;

public interface AdminView {
public int getLogin(String adminName,String password) throws SQLException;

}
