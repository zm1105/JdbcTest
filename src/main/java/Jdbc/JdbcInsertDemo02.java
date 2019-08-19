package Jdbc;

import java.sql.*;

public class JdbcInsertDemo02 {
    public static void main(String[] args) {
        Statement statement = null;
        Connection connection = null;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhoumin?" +
                            "serverTimezone=UTC&" +
                            "useUnicode=true&characterEncoding=utf8&useSSL=false",
                    "zhoumin", "qweasd12345");
            String sql1 = "insert into user values (null,'王八',666666)";
            statement = connection.createStatement();
            int i = statement.executeUpdate(sql1);
            if (i > 0) {
                System.out.println("添加成功");
            } else {
                System.out.println("添加失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}




