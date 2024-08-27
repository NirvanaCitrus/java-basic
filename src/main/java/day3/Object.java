package day3;

public class Object {
    public static void main(String[] args) {

        // 폴더 -> 배열
        // 폴더 -> 숫자, 문자 가리지 않고 다 저장 가능한 개념. ==> 객체

//        int[] hong = new int[3]; // 배열로는 안됨.



        int age = 20;
//        String name = "홍길동";
//        String home = "서울";

        Hugh c = new Hugh(); // 폴더가 만들어졌는가? 그렇다.
        Hugh d = new Hugh();
        Hugh e = new Hugh();

        c.name = "Hugh1";
        d.name = "Hugh2";
        e.name = "Hugh3";

        // Hugh 라는 설계도에 따라서 객체를 하나 만들어라. 그리고 c 변수에 담아줘.

        // 복사본을 만드는 행위가 new, 하나 더 만들겠다 바로 new를 입력. 원본의 틀이 class, 복사로 만드는 것들이 객체.
        // 보통 class 는 틀을 만드는 행위이고 거기에 정보를 바로 입력하지는 않는다. 객체를 생성하고 거기에 정보를 입력.


        // 사람을 표현하는 방법은 무한가지.
        // 자바는 변수 저장할 때 자료형을 요구.
        // 객체는 먼저 어떻게 생겼는지 정의되어야 자바가 만들어 줄 수 있다. -> 설계도(class)를 먼저 만든다.

//        int age2 = 30;
//        String name2 = "이순신";
//        String home2 = "대전";
//
//        System.out.println(age + "살, " + home + " 사는 " + name + "입니다.");
//        System.out.println(age2 + "살, " + home2 + " 사는 " + name2 + "입니다.");


    }
}
