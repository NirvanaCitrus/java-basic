package day2;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println(" 계산기 프로그램 V1 ");
            System.out.println("기능을 선택해주세요: 1(더하기), 2(빼기), 3(곱하기), 4(나누기), 5(종료): ");
            int num = sc.nextInt();

            if (num == 5) {
                System.out.println("계산기 프로그램을 종료합니다.");
                break;

            }

            if (num >= 1 && num <= 4) {
                System.out.println("첫번째 숫자를 입력해주세요: ");
                int num1 = sc.nextInt();
                System.out.println("두번째 숫자를 입력해주세요: ");
                int num2 = sc.nextInt();
                int result = 0;

                if (num == 1) {
                    result = num1 + num2;
                    System.out.println(" 결과 : " + num1 + " + " + num2 + " = " + result);

                } else if (num == 2) {
                    result = num1 - num2;
                    System.out.println(" 결과 : " + num1 + " - " + num2 + " = " + result);

                } else if (num == 3) {
                    result = num1 * num2;
                    System.out.println(" 결과 : " + num1 + " X " + num2 + " = " + result);

                } else if (num == 4) {
                    if (num2 != 0) {
                        result = num1 / num2;
                        System.out.println(" 결과 : " + num1 + " / " + num2 + " = " + result);

                    } else {
                        System.out.println("0으로 나눌수 없습니다. ");
                    }

                }


            } else {
                System.out.println("잘못된 입력입니다. 메인메뉴로 돌아갑니다. ");
                continue;
            }

        }
            sc.close();
    }
    }
