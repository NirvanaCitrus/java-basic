package last;

import java.util.ArrayList;

public class ExceptionHandle {
    public static void main(String[] args) {

        ArrayList<String> arr = new ArrayList<>();

        arr.add("apple");
        arr.add("banana");
        arr.add("orange");

        try {
            System.out.println(arr.get(3)); // 예외 발생 코드

        } catch (IndexOutOfBoundsException e) {
            System.out.println("3번 인덱스는 없습니다.");

        }

        System.out.println("hihi");

        try {
            System.out.println(10 / 0);
            System.out.println(arr.get(3));
        } catch (ArithmeticException e) {
            System.out.println("0으로 나누면 안되요");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("3번 인덱스는 없습니다.");
        } finally {
            System.out.println("여기는 무조건 실행되고 끝남");
        }

        // else if 처럼 catch 를 여러개 붙여서 써도 된다.
        // 마지막에 꼭 처리하고 싶으면 finally를 붙여서 마지막으로 실행시키고 싶은 코드를 입력한다.


        System.out.println("hihi");

        // 자바는 예외 상황 발생시 위험을 감지하고 프로그램을 강제로 종료시킨다.

    }
}
