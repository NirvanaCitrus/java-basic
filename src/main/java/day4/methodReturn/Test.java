package day4.methodReturn;

public class Test {

    public int plus(int num1, int num2) {
        System.out.println(num1 + num2);
        return num1 + num2; // 메서드가 리턴(돌아갈) 때 10이라는 값을 가지고 돌아감.
    }

    public int minus(int num1, int num2) {
        return num1 - num2;
    }

    public int multiple(int num1, int num2) {
        return num1 * num2;
    }

    public int divide(int num1, int num2) {
        return num1 / num2;
    }

    public int square(int num) {
        return num * num;
    }

    // 실수와 정수를 계산하면 결과는 무조건 실수.
    public double circle(int radius) {
        return radius * radius * 3.14;
    }

    public boolean isNegative(int num) {
        if (num <= -1) {
            return true;

        } else {
            return false;
        }
    }

    public int func1() {
        return 10;

    }

    public int func2(int num) {
        return num;
    }

    public int func3(int num) {
        return num * num;

    }

    public int func4(int num1, int num2) {
        return num1 + num2;
    }
    public void printEven(int n) {
        for (int i = 1; i <= n; i++) {
            if(isEven(i)) {
            System.out.println(i + " ");

            }

        }

        System.out.println();
    }
    public boolean isEven(int num) {
        if(num % 2 == 0) {
            return true;

        } else {
            return false;
        }
    }
}
