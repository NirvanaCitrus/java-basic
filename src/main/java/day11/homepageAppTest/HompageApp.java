package day11.homepageAppTest;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class HompageApp {
}

class Homepage {
    Scanner sc = new Scanner(System.in);
    int indexCounter = 3;
    PostView postView = new PostView();
    PostDao postDao = new PostDao();


    public Homepage () {
        new TestExample(postDao);
    }


    public void Run() {
        while (true) {
            System.out.println("===== Homepage =====");
            System.out.println("명령어를 입력하세요 (add, list, delete, update, detail, search, exit): ");
            String command = sc.nextLine();

            if (command.equals("exit")) {
                System.out.println("프로그램이 종료됩니다.");
                break;

            } else if (command.equals("add")) {
                System.out.println("게시물 제목을 입력해주세요: ");
                String title = sc.nextLine();
                System.out.println("게시물 내용을 입력해주세요: ");
                String content = sc.nextLine();
                indexCounter++;

                Post post = new Post(indexCounter, title, content, 0, LocalDateTime.now());

                postDao.addPost(post);
                System.out.println("게시물이 등록되었습니다.");


            } else if (command.equals("list")) {
                System.out.println("======= 게시물 목록 =======");
                if (postDao.getAllPosts().isEmpty()) {
                    System.out.println("등록된 게시물이 없습니다.");

                } else {
                    postView.printPostList(postDao.getAllPosts());

                }


            } else if (command.equals("delete")) {
                System.out.println("삭제할 게시물을 선택해주세요: ");
                int targetId = Integer.parseInt(sc.nextLine());
                Post post = postDao.findPostById(targetId);

                if (post == null) {
                    System.out.println("게시물이 존재하지 않습니다.");
                    return;

                } else {
                    postDao.removePost(post);
                    System.out.println("게시물이 삭제되었습니다.");

                }


            } else if (command.equals("update")) {
                System.out.println("수정할 게시물 번호를 입력해주세요: ");
                int selectId = Integer.parseInt(sc.nextLine());

                Post post = postDao.findPostById(selectId);

                if (post == null) {
                    System.out.println("게시물이 존재하지 않습니다.");
                    continue;
                }

                System.out.println("수정할 게시물 제목: ");
                String newTitle = sc.nextLine();
                System.out.println("수정할 게시물 내용: ");
                String newContent = sc.nextLine();

                post.setTitle(newTitle);
                post.setContent(newContent);
                System.out.println("게시물이 수정되었습니다.");


            } else if (command.equals("detail")) {
                System.out.println("상세보기할 게시물을 선택해주세요: ");
                int targetId = Integer.parseInt(sc.nextLine());

                Post post = postDao.findPostById(targetId);

                if (post == null) {
                    System.out.println("존재하지 않는 게시물 입니다.");
                    continue;

                }

                post.setViewcount(post.getViewcount() + 1);
                postView.printPostDetail(post);

            } else if (command.equals("search")) {
                System.out.println("검색 키워드: ");
                String keyword = sc.nextLine();

                ArrayList<Post> searchedPostList = postDao.getPostByKeyword(keyword);
                postView.printPostList(searchedPostList);

            }
        }
    }
}

