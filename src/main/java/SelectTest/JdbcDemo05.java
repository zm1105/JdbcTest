package SelectTest;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcDemo05 {
    public static void main(String[] args) {
//        Find find = new Find();
//        List<User> all = find.findAll();
//        System.out.println(all);
        List<User> list = new Find().findAll();
        System.out.println(list);
        System.out.println(list.size());
    }
}
