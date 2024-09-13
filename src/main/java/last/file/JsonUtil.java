package last.file;

import betaExam.betaTestApp.Post;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonUtil {

    public String toJsonString(Post post) {

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String jsonString = objectMapper.writeValueAsString(post);
            return jsonString;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Post toPost (String jsonString) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Post post = objectMapper.readValue(jsonString, Post.class);
            return post;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    public String toJsonString(User user) {

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String jsonString = objectMapper.writeValueAsString(user);
            return jsonString;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public User toUser (String jsonString) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            User user = objectMapper.readValue(jsonString, User.class);
            return user;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
}
