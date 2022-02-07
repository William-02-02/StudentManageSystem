package com.lyh.test;

import com.lyh.bean.User;
import com.lyh.dao.UserDao_Imp;
import com.lyh.view.View;
import org.junit.Test;
import org.w3c.dom.ls.LSOutput;

public class UserDaoTest {

//测试登录
    @Test
    public void loginTest(){
        User user = View.indexView();
        int type = new UserDao_Imp().login(user);
        if (type == 1){
            System.out.println("欢迎回来，管理员");
        }else if (type == 2){
            System.out.println("欢迎回来，同学");
        }else {
            System.out.println("登录失败");
        }
    }


//测试增加  增
    @Test
    public void insertTest(){
        User user = View.addMenuView();
        boolean res = new UserDao_Imp().insert(user);
        if (res == true){
            System.out.println("新建成功");
        }else {
            System.out.println("新建失败");
        }
    }


//测试删除  删
    @Test
    public void deleteTest(){
        User user = View.deleteMenuView();
        boolean res = new UserDao_Imp().delete(user);
        if (res == true){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
    }

//测试更新  改
    @Test
    public void updateTest(){
        User user = View.updateMenuView();
        boolean res = new UserDao_Imp().update(user);
        if (res == true){
            System.out.println("更新成功");
        }else {
            System.out.println("更新失败");
        }
    }

//测试查询  查
    @Test
    public void selectTest(){
        String uname = View.selectMenuView();
        User user = new UserDao_Imp().select(uname);
        if (user != null){
            System.out.println("查询成功");
            System.out.println(user);
        }else {
            System.out.println("查询失败，查无此人");
        }
    }
}
