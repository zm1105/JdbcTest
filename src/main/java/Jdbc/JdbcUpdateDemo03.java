package Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUpdateDemo03 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhoumin?" +
                            "serverTimezone=UTC&" +
                            "useUnicode=true&characterEncoding=utf8&useSSL=false",
                    "zhoumin", "qweasd12345");
            String sql = "update user set password=444444 where id=1";
            statement = connection.createStatement();
            int i = statement.executeUpdate(sql);
            if (i > 0) {
                System.out.println("修改成功");
            } else {
                System.out.println("修改失败");
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
