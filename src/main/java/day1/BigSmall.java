package day1;

public class BigSmall {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 15;
        int result;

        if (num2 > num1) {
            result = num2 - num1;
            System.out.println(num2 + "-" + num1 + "=" + result);
        } else if (num2 < num1) {
            result = num1 - num2;
            System.out.println(num1 + "-" + num2 + "=" + result);

        }
    }


}
