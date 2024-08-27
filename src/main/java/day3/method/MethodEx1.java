package day3.method;


// 메서드 - 자동차가 달리게 해주세요 문제. V1/V2.
public class MethodEx1 {
    public static void main(String[] args) {

        Car c1 = new Car();
        Car c2 = new Car();
        Car c3 = new Car();

        c1.dash();
        c1.dash();
        c1.dash();

        System.out.println("===== V2 =====");

        c1.dash();
        c2.dash();
        c3.dash();

    }
}
