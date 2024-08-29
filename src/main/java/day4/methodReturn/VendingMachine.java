package day4.methodReturn;


// 자판기를 돌리는 클래스.

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class VendingMachine {
    Scanner sc = new Scanner(System.in);
    int remainder = 0;
    //    String[] drinks = {" 콜라 ", " 사이다 ", " 커피 "};
    ArrayList<String> beverages = new ArrayList<>() {{
        add(0, "콜라");
        add(1, "사이다");
        add(2, "커피");
    }};


    //    int[] price = {1000, 1200, 800};
    ArrayList<Integer> price = new ArrayList<>() {{
        add(1000);
        add(1200);
        add(800);
    }};
    //    int[] count = {1, 2, 1};
    ArrayList<Integer> count = new ArrayList<>() {{
        add(1);
        add(2);
        add(1);
    }};

    // 왜 int 대신에 void 값을 썻는가?
    // int 는 return 값을 요구하기에 어떤 특정한 값을 계산해서 그 숫자를 다시 사용하는 상황에서만 사용이 가능하다.
    // 지금 같은 경우는 start 라는 동작안에 while 이라는 반복문을 넣어서 어떤 한 시스템을 계속 동작 시키는 명령어 체계를 만들었다.
    // 따라서 return 값을 계산한다고 해도 그 값을 적용시켜서 쓰여질 만한 곳이 마땅히 없음으로 단순 동작을 구현시키는 체계에서는
    // void 로 설정을 하고 나머지 명령 체계를 완성시키는 것이 편리하다.
    public void start() {
        while (true) {
            System.out.println("기능 선택 (1. 돈 투입, 2. 음료 선택, 3. 음료 목록 확인, 4. 잔액 확인, 5. 사용 종료)");
            int menu = Integer.parseInt(sc.nextLine());
            // sc.nextInt() 보다 Integer.parseInt(sc.nextLine()) 을 이용하는 이유.
            // sc.nextInt() 는 Integer 값, 정확히 말하면 숫자만을 입력 받기 때문에
            // 문자와 숫자를 혼합해서 받는 경우에는 Integer.parseInt(sc.nextLine()) 을 이용해서 문자와 숫자의 정보를 동시에 입력 받는 것이 안전하다.
            if (menu == 5) {
                System.out.println("자판기 프로그램이 종료됩니다." + " 남은 돈 " + remainder + "가 반환됩니다. ");
                break;

            } else if (menu == 1) {
                System.out.println("돈을 투입해주세요.");
                int money = Integer.parseInt(sc.nextLine());
                remainder += money;
                System.out.println(" 현재 투입된 금액은 " + money + " 입니다.");

//
            } else if (menu == 2) {
                System.out.println("음료 선택");
                int select = Integer.parseInt(sc.nextLine());
                if (price.get(select) > remainder) {
                    System.out.println("잔액이 부족합니다. ");
                    continue;

                }
                if (count.get(select) <= 0) {
                    System.out.println("해당 음료는 품절되었습니다.");
                    continue;

                }
                System.out.println(beverages.get(select) + "를 뽑았습니다. ");
                remainder -= price.get(select);
                count.set(select, count.get(select) - 1);
                System.out.println(" 잔액은 " + remainder + "원 입니다.");

            } else if (menu == 3) {
                for (int i = 0; i < beverages.size(); i++) {
                    System.out.println("===== 음료 목록 =====");
                    System.out.println(i + ". " + beverages.get(i) + " : " + price.get(i) + "원," + " 남은 수량: " + count.get(i) + " 개 ");
                }

            } else if (menu == 4) {
                System.out.println(" 현재 잔액은 " + remainder + "원 입니다.");

            } else {
                System.out.println("존재하지 않는 기능입니다.");
                continue;
            }

        }
    }
}
