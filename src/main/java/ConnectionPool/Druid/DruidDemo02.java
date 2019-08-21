package ConnectionPool.Druid;

import ConnectionPool.Utils.JdbcDruidUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DruidDemo02 {
    public static void main(String[] args) {
        PreparedStatement preparedStatement =null;
        Connection conn = null;
        /**
         * 完成user表添加信息
         */
        try {
            conn = JdbcDruidUtil.getConnection();
            String sql="insert into user values (null,?,?)";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,"马七");
            preparedStatement.setString(2,"222222");
            int i = preparedStatement.executeUpdate();
            System.out.println(i);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcDruidUtil.close(preparedStatement,conn);
        }
    }
}
