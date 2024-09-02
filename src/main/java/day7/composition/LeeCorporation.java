package day7.composition;

public class LeeCorporation {
    public static void main(String[] args) {


        // 길동이와 길순이를 고용해서 leeCorp가 java와 python 수주가 가능하도록 해주세요.
        // LeeCorp 에서 class 수정 없이 자바 개발자를 교체할 수 있게 해주세요.
        LeeCorp leeCorp = new LeeCorp();
        leeCorp.developer = new Jinee();
        leeCorp.gilsoon = new Gilsoon();

        leeCorp.java();
        leeCorp.python();
    }
}

class Developer {
    public void java () {
        System.out.println("자바 프로그래밍");
    }

}

class LeeCorp {

    Developer developer;
    Gilsoon gilsoon;

    public void java () {
        developer.java();
    }
    public void python () {
        gilsoon.python();
    }
}

class Jinee extends Developer{
    public void java () {
        System.out.println("아주 뛰어난 자바 프로그래밍");
    }
}
