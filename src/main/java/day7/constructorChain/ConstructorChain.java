package day7.constructorChain;

public class ConstructorChain {
    public static void main(String[] args) {
        WhiteDuck wd = new WhiteDuck();
        wd.fly();

    }
}

class Duck {
    public Duck () {
        System.out.println("Duck이 생성됩니다.");
    }
    public void fly () {
        System.out.println("오리가 납니다.");
    }
}

class WhiteDuck extends Duck{
    public WhiteDuck () {
        System.out.println("WhiteDuck이 생성됩니다.");
    }

}

// 객체는 자기 자신의 메소드를 우선적으로 사용.
// 동일한 이름을 가진 자원은 자기자신의 것 (내것)을 우선적으로 사용한다.