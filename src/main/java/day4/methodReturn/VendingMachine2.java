package day4.methodReturn;

public class VendingMachine2 {

    // 값을 세팅 X
    // 연습용으로 하나의 객체만 사용할 때는 미리 넣어두는 것이 편함.

    String[] drinks = {" 콜라 ", " 사이다 ", " 커피 "};
    int[] price = {1000, 1200, 800};
    int remainder = 0;
    int[] count = {1, 2, 1};

    public void inputMoney(int money) {
        remainder = remainder + money; // 증감연산
        // 증감연산의 경우 짧게 표현하는 방법 존재.
        remainder += money; // 위와 같은 코드.
    }

    public String selectBeverage(int target) {
        if (price[target] > remainder) {
            return "잔액 부족"; // return 하게 되면 메소드는 거기서 종료. 더이상 밑으로 안내려감.
        }
        if (count[target] <= 0) {
            return "품절";

        }

        remainder = remainder - price[target];
        remainder -= price[target]; // 차감연산
        count[target]--;

        return drinks[target];

    }

    public int getRemainder() {
        return remainder;
    }

    public void printBeverages() {
        for (int i = 0; i < drinks.length; i++) {
            System.out.println("===== 음료 목록 =====");
            System.out.println(i + ". " + drinks[i] + " : " + price[i] + "원," + " 남은 수량: " + count[i] + " 개 ");
        }
    }
}
