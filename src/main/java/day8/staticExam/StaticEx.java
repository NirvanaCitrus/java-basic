package day8.staticExam;

public class StaticEx {
    public static void main(String[] args) {
        People p1 = new People();
        p1.age = 22;
        p1.name = "홍길동";

        p1.introduce(22,"홍길동");

        People p2 = new People();
        p2.age = 25;
        p2.name = "홍길순";

        p2.introduce(25,"홍길순");




    }
}

class People {
    static int age;
    static String name;

    public void introduce (int age, String name) {
        System.out.println(" 저는 " + age + " 살 " + name + " 입니다.");

    }
}
