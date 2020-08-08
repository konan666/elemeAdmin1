package konan.view.Impl;

import konan.dao.FoodDao;
import konan.dao.Impl.FootDaoImpl;
import konan.domain.Food;
import konan.view.FoodView;

import java.sql.SQLException;
import java.util.List;

public class FoodViewImpl implements FoodView {
    FoodDao dao=new FootDaoImpl();
    @Override
    public List<Food> sx() throws SQLException {
        List list=dao.finall();
        return list;
    }

    @Override
    public int cr(String foodName) throws SQLException {
        int sum=dao.save(foodName);
        return sum;
    }

    @Override
    public int sc(int foodId) throws SQLException {
        int sum=dao.remove(foodId);
        return sum;
    }

    @Override
    public int gx(Food food) throws SQLException {
        int sum=dao.update(food);
        return sum;
    }
}
