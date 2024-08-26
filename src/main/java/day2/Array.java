package day2;

public class Array {
    public static void main(String[] args) {

        int a = 10;
        int b = 20;
        int c = 30;
        int d = 40;
        int e = 50;


        System.out.println(a);
        System.out.println(d);

        // 변수가 많아지면 변수를 관리 및 사용이 힘듦.
        // 1. 변수명이 많아져서 힘듦 -> 변수명을 한개만 쓰면 됨.
        // 2. 변수가 많아서 다 사용하기 힘듦 -> 반복문을 사용하면 됨.

        // 결론: 배열을 사용하면 됨.

        int[] arr = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };

        // 배열 사용시 컴퓨터의 인식은 0부터 시작하는 걸로 인식.
        // 위 같은 경우는 10부터 0으로 시작.

        System.out.println(arr[3]);
        System.out.println(arr[2]);

        int num = 10;
        num = 20;

        System.out.println("==================================");
        System.out.println(arr[2]);
//        arr[2] = 100; // 배열의 특정 위치 값을 새로운 값으로 대입 가능.
        System.out.println(arr[2]);
        System.out.println("===================================");
        for (int i = 0; i < 10; i++) {
            System.out.println(arr[i]);

        }

        // 배열의 길이 정보 확인.
        System.out.println(arr.length);
        // 이걸 코드에 대입:
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);

        }
        // 내가 저장할 값이 몇개인지 모를 때, 개수를 알아도 구체적인 값을 모를 때
        // 비어있는 배열을 만들어 놓고 나중에 값을 저장할 수도 있어야 함.

        // 10개짜리 비어있는 배열을 만들기
        int[] arr2 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        arr2[0] = 30; // 이렇게 비어있는 배열을 만들고 저장 가능.

        // 비어있는 배열을 바로 만들어주는 문법:
        int[] arr3 = new int[10];

        System.out.println(arr3.length);
        arr3[4] = 10;

        // 숫자 배열 -> 숫자만 저장 가능. 다른 타입은 불가능.

        int[] arr4 = {1,2,3,4,5};

        // 문자 배열
        String[] arr5 = {"apple", "banana", "carrot"};

        // 불린 배열
        boolean[] arr6 = {true,false,false,true};


    }
}
