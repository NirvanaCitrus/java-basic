package day5.practice;

import java.util.ArrayList;

public class Exam {
    public static void main(String[] args) {

        //사람 생성
        // 이름, 나이로 생성


        ArrayList<String> names = new ArrayList<>();
        ArrayList<Integer> ages = new ArrayList<>();

        names.add("홍길동");
        names.add("이순신");
        names.add("임꺽정");
        names.add("황진이");

        ages.add(20);
        ages.add(30);
        ages.add(35);
        ages.add(40);

        for (int i = 0; i < names.size(); i++) {
            System.out.println(" 안녕하세요 " + ages.get(i) + " 살 " + names.get(i) + "입니다.");

        }

        names.remove(1);
        ages.remove(1);

        for (int i = 0; i < names.size(); i++) {
            System.out.println(" 안녕하세요 " + ages.get(i) + " 살 " + names.get(i) + "입니다.");
        }

    }
}