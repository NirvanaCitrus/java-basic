package day1;

public class Condition {
    public static void main(String[] args) {
        // 조건
        // if 소괄호 중괄호
        if(false) {
            System.out.println("안녕");
        }

        if(false) {
            System.out.println("안녕");
        }

        int num;
        num = 15;
        if(num > 10){
            System.out.println("num이 10 보다 크다");
        }

        int money;
        money = 1000;

        // 1만원 이상  : 치킨
        // 1만원 미만 : 떡볶이
        if(money >= 10000) {
            System.out.println("치킨");
        }
        if(money < 10000) {
            System.out.println("떡볶이");
        }

       // 맑음 : 날씨가 맑습니다. 나들이 나가세요
       // 흐림: 날씨가 흐립니다. 집에 계세요
       // 비: 비가 옵니다. 우산을 챙기세요
       // 눈: 눈이 옵니다. 눈사람을 만들어보세요.

       int weather;
       weather = 4; // 1-맑음, 2-흐림, 3-비, 4-눈
        if(weather == 1) {
            System.out.println("날씨가 맑습니다. 나들이 나가세요");
        }

        if(weather == 2) {
        System.out.println("날씨가 흐립니다. 집에 계세요");

        }

        if(weather == 3) {
            System.out.println("비가 옵니다. 우산을 챙기세요");
        }

        if(weather == 4) {
            System.out.println("눈이 옵니다. 눈사람을 만드세요");
        }

        // 나이에 따른 학적 표현
        // 초, 중, 고, 성인

        int age;
        age = 15;

        if(age <= 8) {
            System.out.println("초등학생");
        }

        if(age <= 16) {
            if(age > 13){
            System.out.println("중학생");

            }
        }
        if(age <= 19) {
            if(age > 16) {
            System.out.println("고등학생");

            }
        }
        if(age >= 20) {
            System.out.println("성인");
        }










    }
}
