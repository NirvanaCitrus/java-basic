package day3.method;


// 매개변수 4번 문제 - 언어랑 횟수
public class MethodEx7 {
    public static void main(String[] args) {
        Person2 p1 = new Person2();

        p1.greeting1(1);
        p1.greeting1(2);
        p1.greeting1(3);
        System.out.println("==========");

        p1.greeting2(1,3);
        p1.greeting2(3,5);



    }
}
