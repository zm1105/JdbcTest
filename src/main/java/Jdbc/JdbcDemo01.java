package Jdbc;

import java.sql.*;

public class JdbcDemo01 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //注册驱动
        java.sql.DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        //Class.forName("com.mysql.cj.jdbc");
        //获取数据库连接对象
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhoumin?" +
                        "serverTimezone=UTC&" +
                        "useUnicode=true&characterEncoding=utf8&useSSL=false",
                "zhoumin", "qweasd12345");
        /** 定义sql  update
         String sql = "update user set password=222222 where id=2";
         获取执行对象
         Statement statement = connection.createStatement();
         执行sql
         int i = statement.executeUpdate(sql);
         System.out.println(i);**/

        //select
        String sql1 = "select * from user where id=2";
        Statement statement = connection.createStatement();
        //结果集对象
        ResultSet resultSet = statement.executeQuery(sql1);
        while (resultSet.next()) {
            String name = resultSet.getString("username");
            System.out.println(name);
        }
        //释放资源
        statement.close();
        connection.close();
    }
}
