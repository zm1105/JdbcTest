package JdbcTemplate;


import ConnectionPool.Utils.JdbcDruidUtil;
import ConnectionPool.domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class jdbcTemplateDemo02 {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcDruidUtil.getDataSource());

    @Test
    public void update() {
        String sql = "insert into user values (?,?,?)";
        int u = jdbcTemplate.update(sql, null, "丁八", 444444);
        System.out.println();
    }

    @Test
    public void delete() {
        String sql = "delete from  user where id=?";
        int d = jdbcTemplate.update(sql, 6);
        System.out.println(d);
    }

    @Test
    public void select() {
        //封装为Map集合，只能是一条记录
        String sql = "select * from user where id=? ";
        Map<String, Object> map = jdbcTemplate.queryForMap(sql, 1);
        System.out.println(map); //{id=1, username=张三, password=111111}
    }

    @Test
    public void select1() {
        //封装为List集合
        String sql = "select * from user";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }
    }

    @Test
    public void select2() {
        //封装为user对象的List对象
        String sql = "select * from user";
        List<User> list = jdbcTemplate.query(sql, new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {
                User user = new User();
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");

                user.setId(id);
                user.setUsername(username);
                user.setPassword(password);
                return user;
            }
        });
        for (User user : list) {
            System.out.println(user);
        }
    }
    @Test
    public void select2_1() {
        //封装为user对象的List对象
        String sql = "select * from user";
        List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
        for (User user : list) {
            System.out.println(user);
        }
    }
    @Test
    public void select_count(){
        String sql="select count(id) from user";
        Long aLong = jdbcTemplate.queryForObject(sql, long.class);
        System.out.println(aLong);
    }
}