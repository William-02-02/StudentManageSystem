package com.lyh.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC {

    public static void main(String[] args) {

        //加载mysql驱动
        //8.0.28 驱动class改成了com.mysql.cj.jdbc.Driver
        try {

//      加载指定的class文件到java虚拟机的内存.
//      加载时 执行了 包中 静态方法和代码块
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("驱动加载成功");



//                          连接数据库                                  jdbc  数据库类型协议   用户 数据库名等信息
                                //                            url写法: 协议名   +子协议名    +数据源名
                                //                                                                  账户         密码
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data", "root", "123456");
            System.out.println("数据库链接成功");

//           创建执行环境  用于执行sql语句    PreparedStatement防止sql注入
            Statement statement = con.createStatement();
//            执行sql语句 得到结果集   修改删除  executeupdate
            ResultSet result = statement.executeQuery("select * from stuinfo");

//            判断接下来有没有内容
            while (result.next()){
                System.out.print(result.getInt("id")+" ");//根据collumnName找到相应字段
                System.out.print(result.getString("uname")+" ");
                System.out.print(result.getString("upass")+" ");
                System.out.println();

            }


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("驱动加载失败");
            System.out.println("数据库链接失败");

        }

    }

}
