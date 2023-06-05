package programmers.lv1;

// 프로그래머스 Lv1. 직사각형 별찍기 - https://school.programmers.co.kr/learn/courses/30/lessons/12969
public class Ex12969 {

    public static void main(String[] args) {
        solution(5, 3);
        /*
             *****
             *****
             *****
         */
    }

    public static void solution(int a, int b) {
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < a; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

}
