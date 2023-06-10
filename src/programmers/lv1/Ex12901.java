package programmers.lv1;

// 프로그래머스 Lv1. 2016년 - https://school.programmers.co.kr/learn/courses/30/lessons/12901
public class Ex12901 {

    public static void main(String[] args) {
        System.out.println(solution(5, 24)); // TUE
    }

    public static String solution(int a, int b) {
        int[] month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] day = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        int dateSum = 0;
        for (int i = 0; i < a - 1; i++) {
            dateSum += month[i];
        }
        dateSum += b;

        return day[dateSum % 7];

    }

}
