package last.file;

import betaExam.betaTestApp.Post;

import java.time.LocalDateTime;

public class FileTest {
    public static void main(String[] args) {
        Post p1 = new Post(1,"aaa", "aaaa", 0, LocalDateTime.now());


        // 자바의 대부분 정보는 객체라는 형태로 구조화(얼려져)되어 있다.
        // 파일은 기본적으로 텍스트로 저장된다.
        // 자바의 객체를 바로 텍스트로 저장 불가능.
        // 자바의 객체를 먼저 텍스트(문자화)화 시켜야됨. => 직렬화(Serializable).
        // 텍스트를 불러와서 자바의 객체 형태로 만드는 것 => 역직렬화(Deserializable).

        // 객체 직렬화 -> jackson 라이브러리를 이용해 객체를 json 문자화하기

        FileUtil fu = new FileUtil();
        JsonUtil ju = new JsonUtil();

        String jsonString = ju.toJsonString(p1);

        fu.save(jsonString,"test.json");
        String content = fu.load("test.json");

        Post post = ju.toPost(content);
        System.out.println(post.getTitle());

        User u1 = new User();
        u1.setLoginId("gun");
        u1.setLoginPw("1234");
        u1.setUsername("nirvana");

        String userJson = ju.toJsonString(u1);
        fu.save(userJson, "user.json");

        String userContent = fu.load("user.json");
        User u2 = ju.toUser(userContent);
        System.out.println(u2.getUsername());


    }
}
