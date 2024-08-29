package day5.arrayListExam;

import java.util.ArrayList;

public class ArrayListExam {
    public static void main(String[] args) {


        // 생성

        int[] arr = new int[5]; // 길이 5인 배열 생성


        // ArrayList
        ArrayList<Integer> list = new ArrayList<>(); // 비어있는 배열

        // 추가
        // 배열 -> 추가 X
        // ArrayList -> 추가
        // 가장 앞에서부터 추가됨.
        list.add(1); // 0번 방에 추가
        list.add(2); // 1번 방에 추가

        // 조회
        System.out.println(arr[0]); // arr 배열의 0번방 조회

        // ArrayList
        System.out.println(list.get(0)); // list 배열의 0번방 조회
        System.out.println(list.get(1)); // list 배열의 1번방 조회
//        System.out.println(list.get(2)); // error 발생 -> 2번방이 존재하지 않음.

        // 내가 추가하는 만큼 방이 늘어나기 때문에 아직 방이 만들어지지 않은 상태.

        // 수정
        // 배열

        arr[0] = 10; // arr 배열의 0번 방의 값을 10으로 수정.
        System.out.println(arr[0]);

        // ArrayList
        list.set(0,10); // list 배열의 0번 방의 값을 10으로 수정.
        System.out.println(list.get(0));

        // 삭제
        // 배열 -> 삭제 X
        // ArrayList
        System.out.println(list.get(0));
        System.out.println(list.get(1));

        list.remove(0); // 0번방의 값을 삭제. 삭제하면 뒤에 있는 요소들이 앞으로 땡겨짐.
        System.out.println(list.get(0));

        // 데이터의 개수 확인
        // 배열 => length를 제공하기는 하지만 데이터의 개수랑 무관. 내가 직접 보관해야 함.

        // ArrayList
        System.out.println(list.size()); // 1
        list.add(2);
        list.add(3);
        System.out.println(list.size()); // 3

        // 배열보다 ArrayList가 사용성이 훨씬 편하므로 ArrayList 를 주로 사용하고
        // 성능이 중요한 부분에서는 배열을 사용한다.
    }
}
