package konan.view;

import konan.domain.Food;

import java.sql.SQLException;
import java.util.List;

public interface FoodView {
    public List<Food> sx() throws SQLException;
    public int cr(String foodName) throws SQLException;
    public int sc(int foodId) throws SQLException;
    public int gx(Food food) throws SQLException;
}
