package programmers.lv1;

// 프로그래머스 Lv1. 수박수박수박수박수박수? - https://school.programmers.co.kr/learn/courses/30/lessons/12922
public class Ex12922 {

    public static void main(String[] args) {
        System.out.println(solution(3)); // 수박수
        System.out.println(solution(4)); // 수박수박
    }

    public static String solution(int n) {
        String[] arr = {"수", "박"};
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < n; i++) {
            answer.append(arr[i % 2]);
        }

        return answer.toString();
    }

}
