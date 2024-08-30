package day4.methodReturn;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine2 {

    // 값을 세팅 X
    // 연습용으로 하나의 객체만 사용할 때는 미리 넣어두는 것이 편함.


    int remainder = 0;
    ArrayList<Drinks> beverages = new ArrayList<>();

    public VendingMachine2() {
        Drinks d1 = new Drinks("콜라", 1000, 1);
        Drinks d2 = new Drinks("사이다", 1200, 2);
        Drinks d3 = new Drinks("커피", 800, 1);
        beverages.add(d1);
        beverages.add(d2);
        beverages.add(d3);

    }

    public void inputMoney(int money) {
        remainder = remainder + money; // 증감연산
        // 증감연산의 경우 짧게 표현하는 방법 존재.
        remainder += money; // 위와 같은 코드.
    }

    public String selectBeverage(int target) {
        Drinks beverage = beverages.get(target);
        if (beverage.price > remainder) {
            return "잔액 부족"; // return 하게 되면 메소드는 거기서 종료. 더이상 밑으로 안내려감.

        }

        if (beverage.quantity <= 0) {
            return "수량 부족";

        }

//        remainder = remainder - prices.get(target);
        remainder -= beverage.price; // 차감연산
        beverage.quantity--;

        return beverage.name;

    }

    public int getRemainder() {
        return remainder;
    }

    public void printBeverages() {
        System.out.println("===== 음료 목록 =====");
        for (int i = 0; i < beverages.size(); i++) {
            System.out.println(i + ". " + beverages.get(i).name + " : " + beverages.get(i).price + "원," + " 남은 수량: " + beverages.get(i).quantity + " 개 ");
        }
    }
}
