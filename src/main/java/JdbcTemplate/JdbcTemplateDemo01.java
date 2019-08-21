package JdbcTemplate;

import ConnectionPool.Utils.JdbcDruidUtil;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateDemo01 {
    public static void main(String[] args) {
        JdbcTemplate template = new JdbcTemplate(JdbcDruidUtil.getDataSource());
        String sql = "update user set password=? where id=?";
        int update = template.update(sql, 111111, 1);
        System.out.println(update);
    }
}