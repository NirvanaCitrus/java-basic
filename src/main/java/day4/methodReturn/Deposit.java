package day4.methodReturn;

public class Deposit {
    public static void main(String[] args) {
        Account a1 = new Account();

        a1.deposit(1000);
        a1.deposit(2000);
        a1.deposit(3000);

        int money = a1.withdraw(400);
        System.out.println(money);

        int remainder = a1.getRemainder();
        System.out.println(remainder);

        money = a1.withdraw(1400);
        System.out.println(money);





    }
}
