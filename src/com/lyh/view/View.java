package com.lyh.view;

import com.lyh.bean.User;

import java.util.Scanner;

public class View {

    private static Scanner input = new Scanner(System.in);
//  监听键盘输入

    //首页视图
    public static User indexView(){


        System.out.println("====================================================");
        System.out.println("=================== 学生信息管理系统 ==================");
        System.out.println("===================  请根据提示操作  ==================");
        System.out.println("===================    请输入账号：  ==================");

        String uname = input.nextLine();

        System.out.println("===================    请输入密码：  ==================");

        String upass = input.nextLine();

        System.out.println("====================================================");


        return new User(uname,upass);//调用User 的构造方法
    }


    /**
     *
     * @return  item 0-4 用户选择的数字
     */
    //管理员菜单视图
    public static int managerMenuView(){


        System.out.println("====================================================");
        System.out.println("===================  欢迎管理员登录 ==================");
        System.out.println("===================  请根据提示操作  ==================");
        System.out.println("===================    0.退出  ==================");
        System.out.println("===================  1.增加学生信息 ==================");
        System.out.println("===================  2.删除学生信息 ==================");
        System.out.println("===================  3.修改学生信息 ==================");
        System.out.println("===================  4.查询学生信息 ==================");
        System.out.println("====================================================");

        String num = input.nextLine();
        //将String 转换为 int
        int item = Integer.parseInt(num);
        //判断item 是否处于0-4
        if (item <0 ||item > 4){
            System.out.println("输入错误请重新输入");

            return managerMenuView();
        }

        System.out.println("====================================================");

        return item;//调用User 的构造方法
    }




    /**
     * 学生登录后
     * @return  item 0-1 用户选择的数字
     */
    //学生菜单视图
    public static int studentMenuView(){


        System.out.println("====================================================");
        System.out.println("===================  欢迎同学登录 ==================");
        System.out.println("===================  请根据提示操作  ==================");
        System.out.println("===================    0.退出  ==================");
        System.out.println("===================  1.查询个人信息 ==================");
        System.out.println("====================================================");

        String num = input.nextLine();
        //将String 转换为 int
        int item = Integer.parseInt(num);
        //判断item 是否处于0-4
        if (item <0 ||item > 1){
            System.out.println("输入错误请重新输入");

            return studentMenuView();
        }

        System.out.println("====================================================");

        return item;//调用User 的构造方法
    }


    /**
     * 增加学生信息
     * @return User 类  User（uname, upass）
     */
    //管理员增加学生信息视图
    public static User addMenuView(){


        System.out.println("====================================================");
        System.out.println("===================  增加学生信息   ==================");
        System.out.println("===================  请根据提示操作  ==================");
        System.out.println("===================   请输入用户名： ==================");

        String uname = input.nextLine();

        System.out.println("===================    请输入密码：  ==================");

        String upass = input.nextLine();

        System.out.println("====================================================");


        return new User(uname,upass);//调用User 的构造方法
    }



    /**
     * 删除学生信息
     * @return User 类  User（uname, upass）
     */
    //管理员删除学生信息视图
    public static User deleteMenuView(){


        System.out.println("====================================================");
        System.out.println("===================  删除学生信息   ==================");
        System.out.println("===================  请根据提示操作  ==================");
        System.out.println("===============  请输入需要删除的用户名：===============");

        String uname = input.nextLine();

        System.out.println("====================================================");


        return new User(uname);//调用User 的构造方法
    }



    /**
     * 修改学生信息
     * @return User 类  User（uname, upass）
     */
    //管理员修改学生信息视图
    public static User updateMenuView(){


        System.out.println("====================================================");
        System.out.println("===================  更改学生信息   ==================");
        System.out.println("===================  请根据提示操作  ==================");
        System.out.println("============== 请输入需要更改密码的用户名：===============");

        String uname = input.nextLine();

        System.out.println("====================================================");
        System.out.println("=================== 请输入新密码：====================");

        String upass = input.nextLine();
        System.out.println("====================================================");

        return new User(uname,upass);//调用User 的构造方法
    }


    /**
     * 查询学生信息
     * @return User 类  User（uname, upass）
     */
    //管理员查询学生信息视图
    public static String selectMenuView(){


        System.out.println("====================================================");
        System.out.println("===================  查询学生信息   ==================");
        System.out.println("===================  请根据提示操作  ==================");
        System.out.println("===============  请输入需要查询的用户名：===============");

        String uname = input.nextLine();

        System.out.println("====================================================");

        return uname;
    }
}
