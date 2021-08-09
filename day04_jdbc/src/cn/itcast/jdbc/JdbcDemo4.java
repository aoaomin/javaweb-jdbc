package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * account删除一条记录
 * */
public class JdbcDemo4 {
    public static void main(String[] args) {
        Statement stmt = null;
        Connection conn = null;
        //1.注册驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取链接对象
            conn = DriverManager.getConnection("jdbc:mysql://39.101.195.31/mybatis", "root", "123456");
            //3.定义sql
            String sql = "delete from user where id = 3";
            //4.获取sql执行对象
            stmt = conn.createStatement();
            //5.执行sql
            int count = stmt.executeUpdate(sql);
            //6.处理结果
            System.out.println(count);
            if(count>0){
                System.out.println("删除成功!");
            }else {
                System.out.println("删除失败!");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
