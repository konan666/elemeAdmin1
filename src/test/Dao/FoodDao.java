package test.Dao;

import test.domain.Food;

import java.sql.SQLException;
import java.util.List;

public interface FoodDao {
    public List<Food> finall() throws SQLException;
    public int cr(Food food) throws SQLException;
    public int sc(int id) throws SQLException;
    public  int gx(Food food) throws SQLException;
}
