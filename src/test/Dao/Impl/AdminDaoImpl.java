package test.Dao.Impl;

import test.Dao.AdminDao;
import test.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDaoImpl implements AdminDao {

    private Connection conn=null;
    private PreparedStatement pstm;
    private ResultSet rs=null;
    int sum=0;
    @Override
    public int Login(String adminName, String password) throws SQLException{
        conn= JDBCUtils.getConnection();
        String sql="select count(*) count from admin where adminName=? and password=?";
        try{
            pstm=conn.prepareStatement(sql);
            pstm.setString(1,adminName);
            pstm.setString(2,password);
            rs=pstm.executeQuery();
            while (rs.next()){
                sum=rs.getInt("count");
            }

        }catch(SQLException e){

            e.printStackTrace();

        }catch (ClassCastException e){
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,pstm,conn);
        }
        return sum;
    }
}
