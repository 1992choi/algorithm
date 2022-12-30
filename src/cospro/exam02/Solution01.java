package cospro.exam02;

public class Solution01 {

    interface Book {
        public int getRentalPrice(int day);
    }

    class ComicBook implements Book {
        public int getRentalPrice(int day) {
            int cost = 500;
            day -= 2;
            if (day > 0)
                cost += 200 * day;
            return cost;
        }
    }

    class Novel implements Book {
        public int getRentalPrice(int day) {
            int cost = 1000;
            day -= 3;
            if (day > 0)
                cost += 300 * day;
            return cost;
        }
    }

    public int solution(String[] bookTypes, int day) {
        Book[] books = new Book[50];
        int length = bookTypes.length;
        for (int i = 0; i < length; ++i) {
            if (bookTypes[i].equals("comic"))
                books[i] = new ComicBook();
            else if (bookTypes[i].equals("novel"))
                books[i] = new Novel();
        }
        int totalPrice = 0;
        for (int i = 0; i < length; ++i)
            totalPrice += books[i].getRentalPrice(day);
        return totalPrice;
    }


    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Solution01 sol = new Solution01();
        String[] bookTypes = {"comic", "comic", "novel"};
        int day = 4;
        int ret = sol.solution(bookTypes, day);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }

}
