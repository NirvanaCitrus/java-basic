package day6.constructor;

import java.util.ArrayList;
import java.util.Scanner;

public class Kiosk {
    ArrayList<Hamburger> hamburgers = new ArrayList<>();
    ArrayList<SoftDrinks> softDrinks = new ArrayList<>();
    ArrayList<SideMenu> sideMenus = new ArrayList<>();

    ArrayList<Hamburger> selectedHamburgers = new ArrayList<>();
    ArrayList<SoftDrinks> selectedDrinks = new ArrayList<>();
    ArrayList<SideMenu> selectedSides = new ArrayList<>();

    ArrayList<Hamburger> burgerCart = new ArrayList<>();
    ArrayList<SoftDrinks> drinkCart = new ArrayList<>();
    ArrayList<SideMenu> sideCart = new ArrayList<>();

    int total = 0;
    public Kiosk() {
        hamburgers.add(new Hamburger("싸이버거", 3500));
        hamburgers.add(new Hamburger("화이트갈릭버거", 4500));
        hamburgers.add(new Hamburger("휠렛버거", 5000));

        softDrinks.add(new SoftDrinks("콜라", 1000));
        softDrinks.add(new SoftDrinks("에이드", 2000));
        softDrinks.add(new SoftDrinks("커피", 1500));
        softDrinks.add(new SoftDrinks("쉐이크", 2500));

        sideMenus.add(new SideMenu("감자튀김", 1500));
        sideMenus.add(new SideMenu("치즈스틱", 2000));
        sideMenus.add(new SideMenu("치킨너겟", 2500));
        sideMenus.add(new SideMenu("오징어링", 2700));

    }

    Scanner sc = new Scanner(System.in);
    int count = 0;

    public Hamburger selectHamburger(int select) {
        Hamburger burgers = hamburgers.get(select);
        total += burgers.price;
        return burgers;
    }

    public SoftDrinks selectSoftDrinks(int select) {
        SoftDrinks drinks = softDrinks.get(select);
        total += drinks.price;
        return drinks;
    }

    public SideMenu selectSideMenu(int select) {
        SideMenu sideMenu = sideMenus.get(select);
        total += sideMenu.price;
        return sideMenu;
    }

    public void Start() {
        while (true) {
            System.out.println("==== 햄버거 키오스크 v1 ====");
            System.out.println("1. 햄버거 선택, 2. 음료수 선택, 3. 사이드 선택, 4. 메뉴 취소, 5. 주문 하기");
            System.out.println("==== 주문 목록 ====");
            System.out.println("버거 : " + burgerCart.size());
            for (int i = 0; i < burgerCart.size(); i++) {
                System.out.println(burgerCart.get(i).name + " ");

            }

            System.out.println("사이드 : " + sideCart.size());
            for (int i = 0; i < sideCart.size(); i++) {
                System.out.println(sideCart.get(i).name + " ");

            }

            System.out.println("음료수 : " + drinkCart.size());
            for (int i = 0; i < drinkCart.size(); i++) {
                System.out.println(drinkCart.get(i).name + " ");

            }

            System.out.println("총 금액 : " + total + " 원 ");
            System.out.println("무엇을 하시겠습니까?");
            int menu = Integer.parseInt(sc.nextLine());


            if (menu == 1) {
                System.out.println("=== 햄버거 목록 ===");
                for (int i = 0; i < hamburgers.size(); i++) {
                    System.out.printf("%d. %s %d\n", i + 1, hamburgers.get(i).name, hamburgers.get(i).price);

                }
                System.out.println("어떤 버거를 고르시겠습니까 : ");
                int selectNo = Integer.parseInt(sc.nextLine()); // 번호로 버거 선택

                Hamburger hamburger = hamburgers.get(selectNo - 1); // 번호로 버거 가져오기
                burgerCart.add(hamburger); // 버거 카트에 담기.
                total += hamburger.price;


            } else if (menu == 2) {
                System.out.println("=== 음료수 목록 ===");
                for (int i = 0; i < softDrinks.size(); i++) {
                    System.out.printf("%d. %s %d\n", i + 1, softDrinks.get(i).name, softDrinks.get(i).price);

                }
                System.out.println("어떤 사이드를 고르시겠습니까?");
                int selectNo = Integer.parseInt(sc.nextLine());

                SoftDrinks drinks = softDrinks.get(selectNo - 1);
                drinkCart.add(drinks);
                total += drinks.price;

            } else if (menu == 3) {
                System.out.println("=== 사이드 목록 ===");
                for (int i = 0; i < sideMenus.size(); i++) {
                    System.out.printf("%d. %s %d\n", i + 1, sideMenus.get(i).name, sideMenus.get(i).price);

                }
                System.out.println("어떤 음료를 고르시겠습니까?");
                int selectNo = Integer.parseInt(sc.nextLine());

                SideMenu sideMenu = sideMenus.get(selectNo - 1);
                sideCart.add(sideMenu);
                total += sideMenu.price;

            } else if (menu == 4) {
                System.out.println("메뉴 취소");
                System.out.println("어떤 메뉴를 취소하시겠습니까?");
                int cancelMenu = Integer.parseInt(sc.nextLine());

                if (cancelMenu == 1) {
                    Hamburger removedBurger = burgerCart.remove(burgerCart.size() - 1);
                    total -= removedBurger.price;
                    System.out.println(removedBurger.name + " 취소됨 ");
                } else if (cancelMenu == 2) {
                    SideMenu removedSide = sideCart.remove(sideCart.size() - 1);
                    total -= removedSide.price;
                    System.out.println(removedSide.name + " 취소됨 ");

                } else if (cancelMenu == 3) {
                    SoftDrinks removedDrinks = drinkCart.remove(drinkCart.size() - 1);
                    total -= removedDrinks.price;
                    System.out.println(removedDrinks.name + " 취소됨 ");

                } else {
                    System.out.println("취소할 항목이 없습니다");
                }


            } else if (menu == 5) {
                System.out.println("정말로 주문하시겠습니까?");

            } else {
                System.out.println("잘못 선택하셨습니다.");
                continue;
            }

        }
    }

    public static void main(String[] args) {
        Kiosk k1 = new Kiosk();
        k1.Start();
    }

}
