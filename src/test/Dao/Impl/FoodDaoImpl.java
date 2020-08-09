package test.Dao.Impl;

import test.util.JDBCUtils;
import test.Dao.FoodDao;
import test.domain.Food;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodDaoImpl implements FoodDao {
    private Connection conn=null;
    private PreparedStatement pstm=null;
    private ResultSet rs=null;
    private List list=new ArrayList();
    private int sum=0;
    public List<Food> finall() throws SQLException{
        conn= JDBCUtils.getConnection();
        String sql="select * from food";
        try {
            pstm=conn.prepareStatement(sql);
            rs=pstm.executeQuery();
            while (rs.next()){
                Food food=new Food();
                food.setFoodId(rs.getInt(1));
                food.setFoodName(rs.getString(2));
                food.setFoodExplain(rs.getString(3));
                food.setFoodPrice(rs.getDouble(4));
                food.setBusinessId(rs.getInt(5));
                list.add(food);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    public int cr(Food food) throws SQLException {
        conn=JDBCUtils.getConnection();
        String sql="insert into food(foodName,foodExplain,foodPrice,businessId)values(?,?,?,?)";
        pstm=conn.prepareStatement(sql);
        pstm.setString(1,food.getFoodName());
        pstm.setString(2,food.getFoodExplain());
        pstm.setDouble(3,food.getFoodPrice());
        pstm.setInt(4,food.getBusinessId());
        pstm.executeUpdate();
        try {
            String sql2="select foodId from food where foodName=?";
            pstm=conn.prepareStatement(sql2);
            pstm.setString(1,food.getFoodName());
            rs=pstm.executeQuery();
            while(rs.next()){
                sum=rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sum;
    }
    public  int sc(int id) throws SQLException {
        conn=JDBCUtils.getConnection();
        String sql="delete from food where foodId=?";
        try{
            pstm=conn.prepareStatement(sql);
            pstm.setInt(1,id);
            sum=pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sum;
    }
    public int gx(Food food) throws SQLException {
        conn=JDBCUtils.getConnection();
        String sql="update food set foodName=?,FoodExplain=?,FoodPrice=?,BusinessId=? where foodId=?";
        try{
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
