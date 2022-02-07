package com.lyh.jdbc;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {

    private static String driver ;
    private static String url ;
    private static String username ;
    private static String password ;



    //静态语句块
    static {

//  JDBCUtils.class获得对象

//  getClassLoader()类加载器

//  getResourceAsStream("db.properties");  加载资源文件放到输入流中
    InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties");

    //创建properties对象
    Properties p = new Properties();

    try {
//        加载流文件
        p.load(is);

         driver = p.getProperty("driver");
         url = p.getProperty("url");
         username = p.getProperty("username");
         password = p.getProperty("password");

//        加载mysql驱动
        Class.forName(driver);
        System.out.println("驱动加载成功");

    } catch (Exception e) {
        e.printStackTrace();
    }
    }

    public static Connection getConnection(){
        try {
            System.out.println("数据库连接成功");
            return DriverManager.getConnection(url,username,password);

        } catch (SQLException e) {
            System.out.println("数据库连接失败");
            e.printStackTrace();
        }
        return null;
    }


    public static void close(Connection conn, Statement statement, ResultSet result){

        try {
            if(result != null){
                result.close();
                result = null;
            }
            if(statement != null){
                statement.close();
                statement = null;
            }
            if(conn != null){
                conn.close();
                conn = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
