package day4.methodReturn;


// 메서드는 값을 표현할 수도 있고 아닐 수도 있다.
public class Return {
    public static void main(String[] args) {


        // 메서드는 값을 리턴할 수 있는데 리터값이 필요한 이유는 메서드가 리턴한 값을
        // 다양하게 2차 작업할 수 있기 때문
        Test t1 = new Test();

        // 10, 20 더한 값에서 2로 나누고 싶다.
        int num = t1.plus(100, 200);

        System.out.println(num / 2);

        // 10, 20 더한 값에서 2배를 하고 싶다.
        System.out.println(num * 2);


        // 문제. Test에 원의 넓이 구하는 메서드 만들기
        // 원의 넓이 : 반지름 * 반지름 * 3.14

        // 반지름이 5인 원의 넓이:
        Test t2 = new Test();
        double result = t2.circle(5);

        // 반지름이 10인 원의 넓이:

        double result2 = t2.circle(10);

        // 반지름이 5인 원의 넓이를 3으로 나누 값:
        System.out.println(result / 3);


        // 반지름이 10인 원의 넓이를 2배로 증가시킨 값:
        System.out.println(result2 * 2);
        System.out.println("==========");
        int a = t1.func1();
        System.out.println(a);

        int b = t1.func1();
        System.out.println(b);

        int c = t1.func2(22);
        System.out.println(c);

        int d = t1.func2(55);
        System.out.println(d);

        int e = t1.func3(10);
        System.out.println(e);

        int f = t1.func3(5);
        System.out.println(f);

        int g = t1.func4(10,30);
        System.out.println(g);

        int h = t1.func4(20,50);
        System.out.println(h);
        System.out.println("==========");

        int rst1 = t1.plus(10,20);
        System.out.println(rst1);

        int rst2 = t1.minus(10,20);
        System.out.println(rst2);

        int rst3 = t1.multiple(5,4);
        System.out.println(rst3);

        int rst4 = t1.divide(10,3);
        System.out.println(rst4);

        int rst5 = t1.square(5);
        System.out.println(rst5);

        System.out.println("==========");

        Test t3 = new Test();
        int no = -2;

        if(t3.isNegative(no)) {
            System.out.println("음수입니다");
        } else {
            System.out.println("양수입니다");
        }

        System.out.println("==========");
        t3.printEven(20);
    }
}
