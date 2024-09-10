package day11.homepageAppTest;

import java.time.LocalDateTime;

public class TestExample {



    public TestExample(PostDao postDao) {
    Post p1 = new Post(1,"안녕하세요 반갑습니다 자바 공부중이에요.","자바 질문",0, LocalDateTime.now());
    Post p2 = new Post(2,"자바 질문좀 할게요~", "질문:",0,LocalDateTime.now());
    Post p3 = new Post(3, "정처기 따야되나요?", "정처기 질문",0,LocalDateTime.now());
    postDao.addPost(p1);
    postDao.addPost(p2);
    postDao.addPost(p3);

    }


}
