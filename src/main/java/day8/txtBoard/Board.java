package day8.txtBoard;



// 핵심 메서드는 전부 객체로 옮겨서 적는게 좋다.
// 메인의 역활은 스위치 온만 할수 있는 기능으로.

public class Board {
    public static void main(String[] args) {

        BoardApp boardApp = new BoardApp();
        boardApp.run();
    }
}
