package day1;

public class Loop {
    public static void main(String[] args) {

        int count;
        count = 0;

        while (count < 10) {
            System.out.println("안녕하세요");
            count++; // count 값이 1 증가
        }

        int count2 = 0; // 만들고 동시에 값 저장
        while (count2 < 10) {
            System.out.println("반갑습니다");
            count2++;

        }

         //for

        for(int count3 = 0;count3 < 10; count3++) {
            System.out.println("화이팅");

        }

        for (int i = 1; i <= 100; i++) {
            System.out.println(i);

        }

    }
}
