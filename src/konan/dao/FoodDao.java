package konan.dao;

import konan.domain.Food;

import java.sql.SQLException;
import java.util.List;

public interface FoodDao {
    public List<Food> finall() throws SQLException;
    public int save(String foodName) throws SQLException;
    public int remove(int foodId) throws SQLException;
    public int update(Food food) throws SQLException;
}
