package day8.staticExam;

public class StaticEx2 {

}

class Main {
    static int num = 10;

    public static void main(String[] args) {

        // static이 붙은 메서드는 static이 붙지 않은 것은 사용 불가.
        System.out.println(num);

        printValue("안녕");
    }

    public static void printValue (String str) {
        System.out.println(str);
    }
}
