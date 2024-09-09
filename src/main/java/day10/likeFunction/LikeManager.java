package day10.likeFunction;

import java.util.ArrayList;

public class LikeManager {
    private ArrayList<String> likedUsers;

    public LikeManager () {
        this.likedUsers = new ArrayList<>();
    }

    public boolean toggleLike(String username) {
        if (likedUsers.contains(username)) {
            likedUsers.remove(username);
            return false;

        } else {
            likedUsers.add(username);
            return true;
        }

    }

    public boolean hasUserLiked(String username) {
        return likedUsers.contains(username);

    }

    public int getLikeCount() {
        return likedUsers.size();
    }
}
