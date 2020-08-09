package test.view.Impl;

import test.domain.Food;
import test.Dao.FoodDao;
import test.Dao.Impl.FoodDaoImpl;
import test.view.FoodView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodViewImpl implements FoodView {
    FoodDao dao=new FoodDaoImpl();
    private List list=new ArrayList();
    private int sum=0;
    @Override
    public List<Food> finall() throws SQLException {
        list=dao.finall();
        return list;
    }

    @Override
    public int getcr(Food food) throws SQLException {
        sum=dao.cr(food);
        return sum;
    }

    @Override
    public int getsc(int id) throws SQLException{
        sum=dao.sc(id);
        return sum;
    }

    @Override
    public int getgx(Food food) throws SQLException{
        sum=dao.gx(food);
        return sum;
    }
}
