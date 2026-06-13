
package programmers.codingtest;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/42584
public class Ex012 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1,2,3,2,3})));
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length - 1; i++) {
            int sum = 1;
            for (int j = i + 1; j < prices.length - 1; j++) {
                if (prices[i] <= prices[j]) {
                    sum++;
                } else {
                    break;
                }
            }

            answer[i] = sum;
        }

        return answer;
    }

}

/*
    public static int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n]; // ❶ 가격이 떨어지지 않은 기간을 저장할 배열

        // 스택(stack)을 사용해 이전 가격과 현재 가격 비교
        Stack<Integer> stack = new Stack<>(); // ❷ 스택 생성
        stack.push(0);

        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                // ❸ 가격이 떨어졌으므로 이전 가격의 기간 계산
                int j = stack.pop();
                answer[j] = i - j;
            }
            stack.push(i);
        }

        // ❹ 스택에 남아 있는 가격들은 가격이 떨어지지 않은 경우
        while (!stack.isEmpty()) {
            int j = stack.pop();
            answer[j] = n - 1 - j;
        }

        return answer;
    }
 */