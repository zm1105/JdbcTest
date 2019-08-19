package Jdbc;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class JdbcSelectDemo04 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhoumin?" +
                            "serverTimezone=UTC&" +
                            "useUnicode=true&characterEncoding=utf8&useSSL=false",
                    "zhoumin", "qweasd12345");
            statement = connection.createStatement();
            String sql = "select * from user where username='张三'";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                // int password = resultSet.getInt("password");
                String password1 = resultSet.getString("password");
                System.out.println("password1是" + " " + password1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
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
}
