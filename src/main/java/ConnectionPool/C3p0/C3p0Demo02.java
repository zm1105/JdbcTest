package ConnectionPool.C3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class C3p0Demo02 {
    public static void main(String[] args) throws SQLException {
        DataSource dataSource = new ComboPooledDataSource();
        for (int i = 1; i < 101; i++) {
            Connection connection = dataSource.getConnection();
            System.out.println(i + ":" + connection);
            if (i == 5) {
                //归还连接
                connection.close();
            }
        }
    }
}
