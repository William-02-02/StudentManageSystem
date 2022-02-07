package com.lyh.dao;

import com.lyh.bean.User;
import com.lyh.jdbc.JDBCUtils;
import com.lyh.view.View;
import com.sun.org.apache.xerces.internal.xs.XSTerm;

import java.sql.*;

public class UserDao_Imp implements UserDao {

    public static final String SQL_USER_LOGIN = "SELECT type FROM user WHERE uname=? AND upass=?";
    private static final String SQL_USER_INSERT = "INSERT INTO user VALUES(id,?,?,2)";
    private static final String SQL_USER_DELETE = "DELETE FROM user WHERE uname=? AND type=2";
    private static final String SQL_USER_UPDATE = "UPDATE user SET upass=? where uname=?";
    private static final String SQL_USER_SELECT = "SELECT * FROM user where uname=?";

    @Override
    public int login(User user) {
//        连接数据库，创建conn连接对象
        Connection conn = JDBCUtils.getConnection();

        PreparedStatement preparedStatement = null;
        ResultSet result = null;

        try {
//        创建预编译环境
            preparedStatement = conn.prepareStatement(SQL_USER_LOGIN);
//        补全sql语句
            preparedStatement.setString(1,user.getUname());
            preparedStatement.setString(2,user.getUpass());
//        执行补全后的sql语句
            result = preparedStatement.executeQuery();//查询对应 query

            while (result.next()) {
                int type = result.getInt("type");
                return type;
            }


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn,preparedStatement,result);
        }


        return -1;
    }

    @Override
    public boolean insert(User user) {
//        mysql语法   insert into table values(columnLabe,content,,)
//        insert into table1(column1,column,,,) values(value1,value2,,,);
//        INSERT INTO user(uname,upass,type) VALUES('赵六','123',2)  返回受影响行
//        INSERT INTO user VALUES(id,'lyh','123',1)  id 默认自增

        //连接数据库
        Connection conn = JDBCUtils.getConnection();

        PreparedStatement preparedStatement = null;

        try {
//创建预编译环境
            preparedStatement = conn.prepareStatement(SQL_USER_INSERT);

//补充sql语句
            preparedStatement.setString(1,user.getUname());
            preparedStatement.setString(2,user.getUpass());

            int line = preparedStatement.executeUpdate();

            while (line > 0){
                return true;
            }

            //  return line>0?true:false;


        } catch (SQLException e) {
            System.out.println("sql错误");
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn,preparedStatement,null);
        }


        return false;
    }

    @Override
    public boolean delete(User user) {
        //连接数据库  显示所有学生数据
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement preparedStatement=null;

        try {
            //只显示type为2的学生
            preparedStatement = conn.prepareStatement(SQL_USER_DELETE);

            //根据用户名 删除指定用户
            preparedStatement.setString(1,user.getUname());

            int line = preparedStatement.executeUpdate();

            if (line>0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn,preparedStatement, null);
        }
        return false;
    }

    @Override
    public boolean update(User user) {

        Connection conn = JDBCUtils.getConnection();

        PreparedStatement preparedStatement = null;

        try {
//创建预编译环境
            preparedStatement = conn.prepareStatement(SQL_USER_UPDATE);

//补充sql语句
            preparedStatement.setString(2,user.getUname());
            preparedStatement.setString(1,user.getUpass());

            int line = preparedStatement.executeUpdate();

            while (line > 0){
                return true;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn,preparedStatement,null);
        }


        return false;
    }

    @Override
    public User select(String uname) {
//        连接数据库，创建conn连接对象
        Connection conn = JDBCUtils.getConnection();

        PreparedStatement preparedStatement = null;
        ResultSet result = null;

        try {
//        创建预编译环境
            preparedStatement = conn.prepareStatement(SQL_USER_SELECT);

            preparedStatement.setString(1,uname);

//        执行补全后的sql语句
            result = preparedStatement.executeQuery();//查询对应 query
            if (result.next()) {
                int id = result.getInt("id");
                uname = result.getString("uname");
                String upass = result.getString("upass");
                int type = result.getInt("type");

                return new User(id,uname,upass,type);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn,preparedStatement,result);
        }

        return null;
    }


    //输出学生信息的方法
    public void printInfo(User user){
        System.out.println("id: "+user.getId());
        System.out.println("name: "+user.getUname());
        System.out.println("password: "+user.getUpass());
        String str = user.getType() == 1?"管理员":"学生";
        System.out.println("type: "+ str);
    }
}
