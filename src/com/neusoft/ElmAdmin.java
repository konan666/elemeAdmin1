package com.neusoft;

import com.neusoft.dao.AdminDao;
import com.neusoft.dao.Impl.AdminDaoImpl;
import com.neusoft.domain.Admin;
import com.neusoft.domain.Business;
import com.neusoft.view.AdminView;
import com.neusoft.view.impl.AdminViewImpl;

import java.util.List;
import java.util.Scanner;

/**
 * @author Eric Lee
 * @date 2020/8/7 11:30
 */
public class ElmAdmin {
    public static void main(String[] args) {
        work();
    }
    public static  void  work(){
        Scanner input = new Scanner(System.in);

        System.out.println("-----------------------------------------------------------");
        System.out.println("|\t\t\t\t饿了么控制台版后台管理系统 V1.0\t\t\t\t|");
        System.out.println("-----------------------------------------------------------");

        // 调用登录方法
        AdminView adminView = new AdminViewImpl();
        Admin admin = adminView.login();


        if (admin!=null){
            System.out.println("~欢迎来到饿了么商家管理系统~");
            int menu=0;
            while(menu!=5){
            System.out.println("========= 1.所有商家列表=2.搜索商家=3.新建商家=4.删除商家=5.退出系统 =========");
            System.out.println("请输入你的选择");
            Scanner scanner=new Scanner(System.in);
            menu=scanner.nextInt();
                switch (menu){
                    case 1:
                        System.out.println("");
                        List<Business> list=adminView.getselect();

                        System.out.println("商家编号\t商家名称\t商家地址\t商家介绍\t起送费\t配送费");
                        for(Business i:list){
                            System.out.println(i);
                        }

                        break;
                    case 2:

                        System.out.println("请输入商家名");
                        String name=input.next();
                        System.out.println("请输入商家地址");
                        String addr=input.next();
                        List<Business> list1=adminView.setchaxun(name,addr);
                        for(Business a:list1){
                            System.out.println(a);
                        }
                        break;
                    case 3:
                        System.out.println("");
                        break;
                    case 4:
                        System.out.println("");
                        break;
                    case 5:
                        System.out.println("欢迎下次光临！");
                        break;



                }








            }











        }else{
            System.out.println("账号或密码错误");
        }

    }
}
