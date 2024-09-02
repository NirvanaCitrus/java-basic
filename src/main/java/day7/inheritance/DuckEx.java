package day7.inheritance;

public class DuckEx {
    public static void main(String[] args) {
        Duck duck = new Duck();

        duck.fly();

        Mallard mallard = new Mallard();
        mallard.fly();

        WhiteDuck whiteDuck = new WhiteDuck();
        whiteDuck.fly();

        RubberDuck rubberDuck = new RubberDuck();
        rubberDuck.fly();
        rubberDuck.swim();

        RubberDuck rubberDuck1 = new RubberDuck();
        rubberDuck1.fly();
        rubberDuck1.swim();

        AsuraDuck asuraDuck = new AsuraDuck();
        asuraDuck.fly();
        asuraDuck.swim();

    }
}


class Duck {
    public void fly () {
        System.out.println("오리가 날개로 날아갑니다");
    }
    public void swim () {
        System.out.println("오리가 오리발로 헤엄칩니다.");
    }
}

class Mallard extends Duck{

}

class WhiteDuck extends Duck{

}

class RubberDuck extends Duck {
    // 오버라이딩
    public void fly () {
        System.out.println("저는 날수 없어요 ㅜ");
    }

}

class Rubber2Duck extends RubberDuck{

}


// 상속의 한계.
// 객체가 많아지고 상속 관계가 복잡해질 수록 중복 해결이 어려워진다.
// 부모가 두명이 존재할수 없듯.
// 상속을 잘못 사용하면 큰일.
// 상속을 남용하면 좋지 않다.
class AsuraDuck extends Duck {
    public void swim () {
        System.out.println("오리가 둥둥 떠다닙니다.");
    }

}