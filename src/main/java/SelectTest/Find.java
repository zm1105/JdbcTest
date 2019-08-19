package SelectTest;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Find {
    public List<User> findAll() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<User> list = null;
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhoumin?" +
                            "serverTimezone=UTC&" +
                            "useUnicode=true&characterEncoding=utf8&useSSL=false",
                    "zhoumin", "qweasd12345");
            String sql = "select * from user ";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            User user = null;
            list = new ArrayList<User>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                int password = resultSet.getInt("password");
                user = new User();
                user.setUsername(username);
                user.setPassword(password);
                user.setId(id);
                list.add(user);
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
        } if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}