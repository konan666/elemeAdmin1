package test.view;

import test.domain.Food;

import java.sql.SQLException;
import java.util.List;

public interface FoodView {
    public List<Food> finall() throws SQLException;
    public int getcr(Food food) throws SQLException;
    public int getsc(int id) throws SQLException;
    public int getgx(Food food) throws SQLException;
}
