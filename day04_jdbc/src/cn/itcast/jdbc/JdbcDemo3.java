package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * account修改记录
 * */
public class JdbcDemo3 {
    public static void main(String[] args) {
        Statement stmt = null;
        Connection conn = null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取链接对象
            conn = DriverManager.getConnection("jdbc:mysql://39.101.195.31/mybatis", "root", "123456");
            //3.定义sql
            String sql = "update user set pwd = 1500 where id = 2";
            //4.获取执行sql的对象
            stmt = conn.createStatement();
            //5.执行sql
            int count = stmt.executeUpdate(sql);
            //6.处理结果
            System.out.println(count);
            if(count>0){
                System.out.println("修改成功!");
            }
            else {
                System.out.println("修改失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            //7.释放资源
            if (stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
