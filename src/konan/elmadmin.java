package konan;

import konan.domain.Food;
import konan.view.AdminView;
import konan.view.FoodView;
import konan.view.Impl.AdminViewImpl;
import konan.view.Impl.FoodViewImpl;

import java.sql.SQLException;
import java.util.List;

public class elmadmin {
    public static void main(String[] args) throws SQLException {
//        AdminView view=new AdminViewImpl();
//        String adminName="1",password="1";
//        int sum=view.login(adminName,password);
//        System.out.println(sum);
        FoodView view=new FoodViewImpl();
//        List<Food> list=view.sx();
//        for(Food i:list){
//            System.out.println(i);
//        }
        Food food=new Food();
//        String foodName="666";
//        int sum=view.cr(foodName);
//        System.out.println(sum);
//        int sum=14;
//        int su=view.sc(sum);
//        System.out.println(su);
        food.setFoodName("123");
        food.setFoodExplain("789");
        food.setFoodPrice(1.2);
        food.setBusinessId(111);
        food.setFoodId(13);
        int sum=view.gx(food);
        System.out.println(sum);




    }
}
