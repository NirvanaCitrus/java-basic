package day7.composition;

public class Composition {
    public static void main(String[] args) {
        Gildong dong = new Gildong();
        Gilsoon soon = new Gilsoon();


        // 길동 : 자바는 내가 할게. 넌 파이썬만 해.
        dong.java();
        soon.java(); // 자바 프로그래밍 부탁.

    }
}

class Gildong extends Developer{
    public void java () {
        System.out.println("자바 23버전 프로그래밍");
    }
}

class Gilsoon extends Developer{

    Gildong gildong = new Gildong();

    public void java () {
        // 길동이한테 연락.
        gildong.java();
    }
    public void python() {
        System.out.println("파이썬 프로그래밍");
    }
}