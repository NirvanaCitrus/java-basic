package day1;

public class Quiz3 {
    public static void main(String[] args) {

        if ( true ) {
            System.out.println("참");
        }

        if ( false ) {
            System.out.println("거짓");
        }

        int a = 10;
        // `==` => 같다.
        if ( a == 10 ) {
            System.out.println("참");
        }

        // `!=` => 같지 않다.
        if ( a != 10 ) {
            System.out.println("거짓");
        }

        if ( a > 10 ) {
            System.out.println("거짓");
        }

        if ( a >= 10 ) {
            System.out.println("참");
        }

        int b = 10;

        if ( a == b ) {
            System.out.println("참");
        }

        //boolean c => c 에는 오직 true/false 만 담을 수 있다.

        boolean c = a != b;

        if ( c ) {
            System.out.println("참");
        }

        if ( c == false ) {
            System.out.println("참");
        }

        // `!` => 반전
        if ( !c ) {
            System.out.println("거짓");
        }

        // `!` => 반전
        if ( !(!c) ) {
            System.out.println("참");
        }

        boolean d = true;

        if ( c != d ) {
            System.out.println("참");
        }
    }
}
