package day7.composition;

public class CompositionEx {
    public static void main(String[] args) {
        Male m1 = new Male();
        m1.age = 20;
        // age는 변수
        m1.arm = new Arm();  // Arm 타입.
        // arm도 변수

        System.out.println(m1.arm.length + "cm");

        // 객체가 가지고 있는 변수, 메소드
        // ()

    }
}

class Male {
    int age;
    Arm arm;

}

class Arm {
    int length;
    public Arm () {
        length = 100;
    }



}