package konan.dao.Impl;

import com.neusoft.view.AdminView;
import konan.dao.AdminDao;
import konan.domain.Admin;
import konan.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AdminDaoImpl implements AdminDao {
    private Connection conn=null;
    private PreparedStatement pstm=null;
    private ResultSet rs=null;
    int sum=0;
    @Override
    public int finall(String adminName,String password) throws SQLException {
        String sql="select adminId from admin where adminName=? and password=?";
        conn= JDBCUtils.getConnection();
        pstm=conn.prepareStatement(sql);
        pstm.setString(1,adminName);
        pstm.setString(2,password);
        rs=pstm.executeQuery();
        while (rs.next()){
            sum=rs.getInt(1);
        }
        return sum;
    }
}
