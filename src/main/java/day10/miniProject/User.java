package day10.miniProject;

public class User {
    private String userId;
    private String password;
    private String username;

    public User(String userId, String password, String username) {
        this.userId = userId;
        this.password = password;
        this.username = username;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
