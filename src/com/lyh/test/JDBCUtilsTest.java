package com.lyh.test;

import com.lyh.jdbc.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCUtilsTest {



    @Test
    public void jdbcConnectionTest() throws Exception{
        //加载驱动 并连接数据库
        Connection conn = JDBCUtils.getConnection();
        //创建运行环境
        Statement statement = conn.createStatement();
        //执行sql语句
        ResultSet result = statement.executeQuery("select * from stuinfo");

        while (result.next()){
            System.out.print(result.getInt("id")+" ");
            System.out.print(result.getString("uname")+" ");
            System.out.print(result.getString("upass")+" ");
            System.out.println();
        }

        JDBCUtils.close(conn,statement,result);



    }
}
