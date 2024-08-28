package day4.methodReturn;

public class Account {
    int remainder = 0;

    public void deposit(int money) {
        remainder = remainder + money;
        System.out.println(money + "원을 예금했습니다.");

    }

    public int withdraw(int money) {
        remainder = remainder - money;
        return money;


    }

    public int getRemainder() {
        return remainder;
    }
}