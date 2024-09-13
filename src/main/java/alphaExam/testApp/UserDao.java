package alphaExam.testApp;

import java.util.ArrayList;

public class UserDao {
    private ArrayList<User> users = new ArrayList<>();

    public void addUser (User user) {
        users.add(user);

    }

    public boolean isUserIdTaken (String userId) {
        for (User user : users) {
            if (user.getUserId().equals(userId)) {
                return true;

            }

        }
        return false;

    }

    public User getUserById (String userId) {
        for (User user : users) {
            if (user.getUserId().equals(userId)) {
                return user;

            }

        }
        return null;

    }
}
