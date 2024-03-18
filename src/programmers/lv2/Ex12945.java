package programmers.lv2;

// 프로그래머스 Lv2. 피보나치 수 - https://school.programmers.co.kr/learn/courses/30/lessons/12945
public class Ex12945 {

    public static void main(String[] args) {
        System.out.println(solution(3)); // 2
        System.out.println(solution(5)); // 5
    }

    public static int solution(int n) {
        int[] fibo = new int[n + 1];
        fibo[0] = 0;
        fibo[1] = 1;
        fibo[2] = 1;

        for (int i = 3; i <= n; i++) {
            fibo[i] = (fibo[i - 1] + fibo[i - 2]) % 1234567;
        }

        return fibo[n];
    }

}

