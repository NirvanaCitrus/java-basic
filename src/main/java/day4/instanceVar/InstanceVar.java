package day4.instanceVar;

public class InstanceVar {
    public static void main(String[] args) {

        Person p1 = new Person();// 지난 내용, new 로 클래스를 불러오면 객채와 리모콘(참조값) 두개가 만들어진다.
        p1.name = "홍길동";
        p1.intro();

        Person p2 = new Person();
        p2.name = "이순신";
        p2.intro();

        p1.walk();
        p2.walk();

    }
}
