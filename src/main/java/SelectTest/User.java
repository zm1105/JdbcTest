package SelectTest;

/**
 * 封装user数据的JavaBean
 */
public class User {
    private int id;
    private int password;
    private String username;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
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
