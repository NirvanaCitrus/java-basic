package day6.constructor;

public class ConstructorEx {
    public static void main(String[] args) {
        Person p1 = new Person(27, "홍길동");


        Person p2 = new Person(25, "홍길순");
        p1.introduce();
        p2.introduce();

        Car c1 = new Car(30, "싼타페","파란");


        Car c2 = new Car(55,"우라칸","노란");

        c1.drive();
        c2.drive();

        Cat cat1 = new Cat();
        cat1.name = "아리";
        cat1.kind = "브리티시 코튼";
        cat1.age = 5;

        Cat cat2 = new Cat();
        cat2.name = "엘렌";
        cat2.kind = "러시안 블루";
        cat2.age = 7;

        cat1.meow();
        cat2.meow();

        Warrior s1 = new Warrior();
        s1.name = "이순신";
        s1.attack = 30;
        s1.defense = 50;

        Warrior s2 = new Warrior();
        s2.name = "강감찬";
        s2.attack = 15;
        s2.defense = 80;

        s1.status();
        s1.attack();
        s1.defense();

        s2.status();
        s2.attack();
        s2.defense();





    }
}


class Person {
    int age;
    String name;

    public Person (int age, String name) {
        System.out.println("사람이 태어납니다.");
        this.age = age; // this 는 메소드를 수행하는 객체를 의미한다.
        this.name = name;

    }

    public void introduce() {

        System.out.printf("안녕하세요 %d살 %s입니다.\n", this.age, this.name);
    }
}

class Car {
    String model;
    String color;
    int speed;

    public Car (int speed, String model, String color) {
        System.out.println("차가 만들어집니다.");
        this.speed = speed;
        this.model = model;
        this.color = color;
    }

    public void drive () {
        System.out.printf("%s %s이/가 %dkm로 달립니다.\n", this.color, this.model, this.speed);
    }
}

class Cat {
    String name;
    String kind;
    int age;

    public Cat () {
        System.out.println("고양이가 태어납니다.");
    }

    public void meow () {
        System.out.printf(" %d살 %s 고양이 %s가 야옹하고 웁니다.\n", age, kind, name);
    }
}

class Warrior {
    String name;
    int attack;
    int defense;

    public Warrior () {
        System.out.println("전사가 태어납니다.");
    }

    public void status () {
        System.out.printf("이름 : %s, 공격력 : %d, 방어력 : %d \n", name, attack, defense);
    }
    public void attack () {
        System.out.printf("%s이 %d의 데미지를 입혔습니다.\n", name, attack);
    }
    public void defense () {
        System.out.printf("%s이 %d 데미지를 방어합니다.\n", name, defense);
    }
}