package day3.method;


// 메서드 매개변수 2,3 문제 - 해결함
public class MethodEx6 {
    public static void main(String[] args) {

        Person p1 = new Person();
        p1.name = "홍길동";
        p1.age = 20;

        p1.introduce(3);
        System.out.println("==========");
        p1.introduce(5);
        System.out.println("==========");
        p1.introduce(10);

    }
}
