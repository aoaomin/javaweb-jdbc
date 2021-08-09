package cn.itcast.jdbc;

import java.sql.*;
import java.util.Date;

/*
 * account删除一条记录
 * */
public class JdbcDemo9 {
    public static void main(String[] args) {
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        //1.注册驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取链接对象
            conn = DriverManager.getConnection("jdbc:mysql://39.101.195.31/db3", "root", "123456");
            //3.定义sql
            String sql = "select * from emp";
            //4.获取sql执行对象
            stmt = conn.createStatement();
            //5.执行sql
            rs = stmt.executeQuery(sql);
            //6.处理结果
            while(rs.next()){
                //获取数据
                int id = rs.getInt("id");
                String ename = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bonus = rs.getDouble("bonus");
                int dept_id = rs.getInt("dept_id");
                System.out.println(id+ename+job_id);
            }

            ////6.1让游标向下移动一行
            // if (rs.next()) {
            //     //判断是否有数据
            //     //6.2获取数据
            //     int id = rs.getInt(1);
            //     String name = rs.getString("name");
            //     double balance = rs.getDouble(3);
            //     System.out.println(id+"---"+name+"---"+balance);
            // }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
