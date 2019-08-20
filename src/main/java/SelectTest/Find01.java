package SelectTest;

import Util.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Find01 {
    public List<User> findAll2() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<User> list = null;
        try {
            connection=JdbcUtils.getconnection();
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
            JdbcUtils.close(resultSet,statement,connection);
        }
        return list;
    }
}