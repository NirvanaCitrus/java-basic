package day8.staticExam;

public class StaticExam {
    public static void main(String[] args) {

        Person p1 = new Person(20,"홍길동");
        Person p2 = new Person(30, "이순신");

        p1.introduce();
        p2.introduce();

        p1.age++;

        // 클래스와 객체를 따로 만드는 이유. 같은 구조인데 서로 다른 정보를 갖게 하기 위함.
        // 복사본인 객체를 만들어서 서로 다른 정보를 저장해야 한다.

        p2.introduce(); // p1의 나이를 올렸기 때문에 p2의 나이는 변경되지 않는다.

        p1.printAverageAge();
        p2.printAverageAge();

        // 인류 평균 나이 81로 정정
        p1.averageAge = 81;
        p1.printAverageAge(); // static 붙이기 전: p1의 인류 평균 나이는 81로 수정되어 출력됨
        p2.printAverageAge(); // Static 붙이기 전: p2의 인류 평균 나이는 여전히 80으로 출력됨.

        // 객체는 자신만의 개성을 표현하기 위해 존재. 간혹 모든 객체가 공유하는 정보가 있을 수 있다.
        // 객체간 공유 정보를 static으로 표현.


        // 메서드는 일반적으로 객체화 한 후에 사용 가능하지만, static을 붙이면 class 에서 바로 사용 가능.
        Person.printAverageAge(); // new 를 하지 않아도 바로 사용이 가능하다.
        // 공유할 목적이 있는 변수에만 static을 붙인다.
        // static은 꼭 필요한 경우에만 사용해야 하며, 메서드에서도 static 변수를 사용할 때나 객체가
        // 가지고 있는 변수를 사용하지 않는 경우에만 static을 붙여야 한다. 남용하지 말것.
    }
}


