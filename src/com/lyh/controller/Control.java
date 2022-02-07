package com.lyh.controller;

import com.lyh.bean.User;
import com.lyh.dao.UserDao_Imp;
import com.lyh.view.View;

public class Control {

    static User user = null;

    public static void main(String[] args) {
        //登录界面展示
        //输入用户名 密码
        while (true) {
            user = View.indexView();
            //检测登录信息  选择进入系统
            UserDao_Imp userDao_imp = new UserDao_Imp();
            int type = userDao_imp.login(user);

            switch (type) {
//            -1：登录失败  1: 管理员登陆  2：学生登陆
                case -1:
                    System.out.println("信息有误,请重新输入");
                    break;
                case 1:
                    System.out.println("欢迎回来，管理员");
                    manageServer();
                    break;
                case 2:
                    System.out.println("欢迎回来，同学");
                    studentServer();
                    break;
                default:
                    break;


            }
        }





    }

    //================================manageServer=================================//
    private static void manageServer(){

        while (true) {
            int item = View.managerMenuView();
            UserDao_Imp dao = new UserDao_Imp();
            switch (item) {
                case 0:
                    System.exit(-1);
                    break;
                case 1://增
                    User user = View.addMenuView();
                    boolean flag = dao.insert(user);
                    System.out.println(flag == true ? "添加成功" : "添加失败");
                    break;
                case 2://删
                    User user1 = View.deleteMenuView();
                    boolean res = dao.delete(user1);
                    System.out.println(res == true ? "删除成功" : "删除失败");

                    break;
                case 3://改
                    User user2 = View.updateMenuView();
                    boolean update = dao.update(user2);
                    System.out.println(update == true ? "学生信息更新成功" : "学生信息更新失败");

                    break;
                case 4://查
                    String s = View.selectMenuView();
                    User ans = dao.select(s);
                    System.out.println(ans ==null?"查询失败，查无此人":"查询成功");
                    dao.printInfo(ans);

                    break;
                default:
                    break;


            }
        }


    }

    //================================studentServer=================================//

    private static void studentServer(){
        //item 为0/1  退出   查询个人信息
        int item = View.studentMenuView();

        //学生登录 输出个人信息
        UserDao_Imp dao = new UserDao_Imp();

        //个人信息获取
        User info = dao.select(user.getUname());


        switch(item){
            case 0:
                System.exit(-1);
                break;
            case 1:
                dao.printInfo(info);
                break;
            default:
                break;


        }

    }

}
