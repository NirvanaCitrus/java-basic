package day7.inheritance;

import day5.arrayListExam.Person;

public class Inheritance {
    public static void main(String[] args) {
        Dog d1 = new Dog();
        d1.bark();
        d1.breathe();

        Cat c1 = new Cat();
        c1.meow();
        c1.breathe();

        Parson p1 = new Parson();
        p1.breathe();
    }
}

class Dog extends Animal {
    public void bark () {
        System.out.println("멍멍 짖다.");
    }

    // 중복
}

class Animal {
    public void breathe () {
        System.out.println("숨쉬다");
    }
    public void bark () {
        System.out.println("");
    }
}

class Cat extends Animal{
    public void meow () {
        System.out.println("야옹");
    }
}
// 중복은 프로그램하는 태생에 있어서 가장 기피해야될 항목.

// 상속을 주는 명령어 extends.
// 생성자가 사라진 객체를 자바가 어떻게 해석해야 되는지 힌트를 주는 용도.
// 기능을 물려주는 용도.

// 사람 만들어서 숨쉬게 하기.
class Parson extends Animal {

}
 // 숨쉬다.

