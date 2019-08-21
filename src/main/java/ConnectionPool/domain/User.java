package ConnectionPool.domain;

/**
 * 封装user数据的JavaBean
 */
public class User {
    private int id;
    private String password;
    private String username;

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", password=" + password +
                ", username='" + username + '\'' +
                '}';
    }
}
