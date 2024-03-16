package programmers.lv2;

// 프로그래머스 Lv2. 타겟 넘버 - https://school.programmers.co.kr/learn/courses/30/lessons/43165
public class Ex43165 {

    static int answer = 0;
    static int level = 0;
    static boolean[] check;

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 1, 1, 1}, 3)); // 5
        System.out.println(solution(new int[]{4, 1, 2, 1}, 4)); // 2
    }

    public static int solution(int[] numbers, int target) {
        answer = 0;
        level = numbers.length - 1;
        check = new boolean[numbers.length];

        dfs(numbers, target, 0);

        return answer;
    }

    public static void dfs(int[] numbers, int target, int n) {
        if (n == level + 1) {
            int sum = 0;
            for (int i = 0; i < numbers.length; i++) {
                if (check[i]) {
                    sum += numbers[i];
                } else {
                    sum -= numbers[i];
                }
            }
            if (sum == target) {
                answer++;
            }
        } else {
            check[n] = true;
            dfs(numbers, target, n + 1);
            check[n] = false;
            dfs(numbers, target, n + 1);
        }
    }

}

