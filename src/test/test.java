package test;


import test.domain.Food;
import test.view.AdminView;
import test.view.FoodView;
import test.view.Impl.AdminViewImpl;
import test.view.Impl.FoodViewImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class test {


    public static void main(String[] args) throws SQLException {

        work();
    }
    public static void work() throws SQLException {
        Scanner input=new Scanner(System.in);
        System.out.println("请输入账号");
        String adminName=input.next();
        System.out.println("请输入密码");
        String password=input.next();
        AdminView dao=new AdminViewImpl();
        FoodView dao1=new FoodViewImpl();
        Food food= new Food();
        int sum=dao.getLogin(adminName,password);
        if(sum==1) {

            System.out.println("欢迎登陆后台中心");
            int menu=0;
            while (menu != 5) {
                System.out.println("========= 1.所有商家列表=2.搜索商家=3.新建商家=4.删除商家=5.退出系统 =========");
                System.out.println("请输入你的选择");
                Scanner scanner=new Scanner(System.in);
                menu=scanner.nextInt();
                switch (menu) {
                    case 1:

                        List<Food> list=dao1.finall();
                        for (Food i:list){
                            System.out.println(i);

                        }
                        break;
                    case 2:
                    System.out.println("请输入要修改的商家ID");
                    int foodId=input.nextInt();
                    System.out.println("请输入修改的商家名称");
                    String foodName=input.next();
                    System.out.println("请输入要修改的商家");
                    String foodd=input.next();
                    System.out.println("请输入要修改的的金额");
                    double money=input.nextDouble();
                    System.out.println("请输入要修改的上级id");
                    int idd=input.nextInt();
                    food.setFoodId(foodId);
                    food.setBusinessId(idd);
                    food.setFoodName(foodName);
                    food.setFoodExplain(foodd);
                    food.setFoodPrice(money);
                    int summ=dao1.getgx(food);
                    if(summ==1){
                        System.out.println("success");}else{
                        System.out.println("error");
                    }
                    break;
                    case 3:
                        System.out.println("请输入商家名称");
                        String foodName1=input.next();
                        System.out.println("请输入商家");
                        String foodd1=input.next();
                        System.out.println("请输入金额");
                        double money1=input.nextDouble();
                        System.out.println("请输入上级id");
                        int idd1=input.nextInt();
                        food.setBusinessId(idd1);
                        food.setFoodName(foodName1);
                        food.setFoodExplain(foodd1);
                        food.setFoodPrice(money1);
                        int summm=dao1.getcr(food);
                        if(summm!=0){
                            System.out.println("商家ID"+summm);}else{
                            System.out.println("error");
                        }
                        break;
                    case 4:
                        System.out.println("请输入删除商家id");
                        int iid=input.nextInt();
                        int s=dao1.getsc(iid);
                        if(s==1){
                            System.out.println("success");}else{
                            System.out.println("error");
                        }
                        break;
                    case 5:
                        break;
                }
            }
        }
    }
}
