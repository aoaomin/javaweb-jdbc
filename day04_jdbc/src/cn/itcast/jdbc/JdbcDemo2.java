package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * account表添加一条记录insert语句
 * */
public class JdbcDemo2 {
    public static void main(String[] args) {
        //1.注册驱动
        Connection conn = null ;
        Statement stmt = null ;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2.定义SQL
            String sql = "insert into account values(null,'章傲',1000)";
            //3.获取connection对象
            conn = DriverManager.getConnection("jdbc:mysql://39.101.195.31/db3", "root", "123456");
            //4.获取执行sql的对象statement
            stmt = conn.createStatement();
            //5.执行sql
            int count = stmt.executeUpdate(sql);
            //6.处理结果
            System.out.println(count);
            if (count > 0) {
                System.out.println("添加成功!");
            } else {
                System.out.println("添加失败!");
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            //stmt.close();
            //避免空指针异常
            if(stmt !=null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn !=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
