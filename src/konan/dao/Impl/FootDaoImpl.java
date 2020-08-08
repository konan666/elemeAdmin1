package konan.dao.Impl;

import jdk.nashorn.internal.scripts.JD;
import konan.dao.FoodDao;
import konan.domain.Food;
import konan.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FootDaoImpl implements FoodDao {
    private Connection conn=null;
    private PreparedStatement pstm=null;
    private ResultSet rs=null;
    int sum=0;
    @Override
    public List<Food> finall() throws SQLException {
        conn= JDBCUtils.getConnection();
        List list=new ArrayList();
        try {
            String sql="select * from food";
            pstm=conn.prepareStatement(sql);
            rs=pstm.executeQuery();
            while (rs.next()){
                Food f=new Food();
                f.setFoodId(rs.getInt(1));
                f.setFoodName(rs.getString(2));
                f.setFoodExplain(rs.getString(3));
                f.setFoodPrice(rs.getDouble(4));
                f.setBusinessId(rs.getInt(5));
                list.add(f);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,pstm,conn);
        }
          return list;

    }

    @Override
    public int save(String foodName) throws SQLException {
        conn=JDBCUtils.getConnection();
           System.out.println(foodName);
            String sql="insert into food(foodName) values (?)";
            pstm=conn.prepareStatement(sql);
            pstm.setString(1,foodName);
            pstm.executeUpdate();
        try {
            String sql2="select foodId from food where foodName=?";
            pstm=conn.prepareStatement(sql2);
            pstm.setString(1,foodName);
            rs=pstm.executeQuery();
            while (rs.next()){
                sum=rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sum;
    }

    @Override
    public int remove(int foodId) throws SQLException {
        conn= JDBCUtils.getConnection();
        String sql="delete from food where foodId=?";
        try {
            pstm=conn.prepareStatement(sql);
            pstm.setInt(1,foodId);
            sum=pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sum;
    }

    @Override
    public int update(Food food) throws SQLException {
        conn=JDBCUtils.getConnection();

        String sql="update food set foodName=?,foodExplain=?,foodPrice=?,businessId=? where foodId=?";
        try {
            pstm=conn.prepareStatement(sql);
            pstm.setString(1,food.getFoodName());
            pstm.setString(2,food.getFoodExplain());
            pstm.setDouble(3,food.getFoodPrice());
            pstm.setInt(4,food.getBusinessId());
            pstm.setInt(5,food.getFoodId());
            sum=pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sum;
    }
}
