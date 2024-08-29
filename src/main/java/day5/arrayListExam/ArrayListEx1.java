package day5.arrayListExam;

import java.util.ArrayList;

public class ArrayListEx1 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(0);

        System.out.println(list.get(2));
        System.out.println(list.get(3));

        list.remove(0);
        list.remove(1);

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));

        System.out.println("==========");

        ArrayList<Integer> whole = new ArrayList<>();
        whole.add(0,5);
        whole.add(1,4);
        whole.add(2,3);
        whole.add(3,2);
        whole.add(4,1);
        whole.add(5,0);

        System.out.println(whole.size());
        System.out.println(whole.get(2));
        System.out.println(whole.get(3));

        whole.remove(0);
        whole.remove(0);

        System.out.println(whole.get(2));
        System.out.println(whole.get(3));
        System.out.println("==========");

        for (int i = 0; i < whole.size(); i++) {
            System.out.println(whole.get(i));

        }



    }
}
