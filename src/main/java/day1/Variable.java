package day1;

public class Variable {
    public static void main(String[] args) {
        // 홍길동의 나이가 20.
        // 홍길동의 나이가 21로 올라감
        System.out.println(20);
        System.out.println(20);
        System.out.println(20);
        System.out.println(20);
        System.out.println(20);

        // 변수를 사용해서 값을 저장.
        // 변수 = 상자
        // 상자는 이름이 있어야 하고.
        // 상자는 크기와 모양이 구분.

        // 숫자
        // 상자(변수)를 만들기
        int age;

        // 값을 변수에 담기
        // = 을 이용해서 저장 가능
        age = 21;

        // 문자
        String name;
        name = "안녕하세요 저는 21살 홍길동입니다";

        String rename;
        rename = "홍길만";

        // 변수의 값을 꺼내서 사용
        System.out.println(age);
        System.out.println(name);

        // 안녕하세요 저는 20살 홍길동입니다. 10번 출력
        // 나이가 21살이 됨. 21살로 바꿔서 10번 출력
        // 홍길만으로 개명. 바뀐 이름으로 10번 출력

        System.out.println("안녕하세요 저는 " + age + "살" + rename + "입니다");
        System.out.println("안녕하세요 저는 " + age + "살" + rename + "입니다");
        System.out.println("안녕하세요 저는 " + age + "살" + rename + "입니다");
        System.out.println("안녕하세요 저는 " + age + "살" + rename + "입니다");
        System.out.println("안녕하세요 저는 " + age + "살" + rename + "입니다");
        System.out.println("안녕하세요 저는 " + age + "살" + rename + "입니다");
        System.out.println("안녕하세요 저는 " + age + "살" + rename + "입니다");
        System.out.println("안녕하세요 저는 " + age + "살" + rename + "입니다");
        System.out.println("안녕하세요 저는 " + age + "살" + rename + "입니다");
        System.out.println("안녕하세요 저는 " + age + "살" + rename + "입니다");

        // 변수 사용시 주의사항
        // 동일한 이름의 변수가 2개 이상 존재할 수 없다.
        // 변수명이 숫자나 특수기호로 시작해서는 안된다. 숫자에 한해서는 뒤쪽에 붙이는건 가능
        // 변수는 재활용 가능

        int a;
        a = 10;
        System.out.println(a);
        a = 20;
        System.out.println(a);




    }
}
