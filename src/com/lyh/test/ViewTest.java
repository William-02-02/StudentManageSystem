package com.lyh.test;

import com.lyh.bean.User;
import com.lyh.view.View;
import org.junit.Test;

public class ViewTest {

    @Test
    public void indexViewTest(){

        User user1 = View.indexView();
        System.out.println(user1.toString());
    }


    @Test
    public void managerMenuViewTest(){

        int n = View.managerMenuView();
        System.out.println(n);
    }

    @Test
    public void addMenuViewTest(){

        User user = View.addMenuView();
        System.out.println(user);
    }

    @Test
    public void deleteMenuViewTest(){

        User user = View.deleteMenuView();
        System.out.println(user);
    }


}
