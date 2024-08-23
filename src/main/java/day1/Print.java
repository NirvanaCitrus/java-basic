package day1;

public class Print {

    // 주석(comment) : 사람이 보기 위한 코멘트, 메세지. 컴퓨터는 무시합니다. (한줄 주석)
    // 여러줄 주석 : 컨트롤 + /
    public static void main(String args[]) {

        // 프로그램 명령어(코드)는 위에서 아래로 순차 실행.

        // 출력 > System.out.print() 괄호 안의 값을 콘솔에 출력
        System.out.print(100);
        System.out.print(777);

        // 출력 -> System.out.println(): 출력 후 줄 바꿈 명령어
        System.out.println(100);
        System.out.println(777);

        // 문자의 경우는 ""를 이용해 구별해야 한다.
        System.out.println("김건주");

        // 더하기 출력
        System.out.println(100 + 200);

        // 수식 전체 표현하기
        System.out.println("100 + 200 = 300");

        // 숫자 + 숫자 => 더하기 산술 연산
        // 문자 + 문자 => 이어 붙이기
        // 문자 + 숫자 => 숫자가 문자가 되어서 이어 붙이기
        System.out.println("100 + 200 = " + 300);

        System.out.println("100 + 200 = " + (100 + 200));

        // 하나의 출력문에서 줄 바꿈을 하기
        // 줄 자꿈 문자: \n
        System.out.println("안녕하세요\n반갑습니다.");


    }
}
