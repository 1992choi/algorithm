package programmers.lv2;

// 프로그래머스 Lv2. N개의 최소공배수 - https://school.programmers.co.kr/learn/courses/30/lessons/12953
public class Ex12953 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 6, 8, 14})); // 168
        System.out.println(solution(new int[]{1, 2, 3})); // 6
    }

    public static int solution(int[] arr) {
        int answer = 1;

        while (true) {
            answer++;
            int checkCount = 0;
            for (int num : arr) {
                if (answer % num == 0) {
                    checkCount++;
                }
            }

            if (checkCount == arr.length) {
                break;
            }
        }

        return answer;
    }

}

