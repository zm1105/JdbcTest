package SelectTest;

import java.util.List;

public class JdbcDemo06 {
    public static void main(String[] args) {
        List<User> list=new Find01().findAll2();
        System.out.println(list);
    }
}
