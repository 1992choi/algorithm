package inflearn.lecture02;

public class Ex02_04 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 2, 3, -1, -1, -1, 3, 1, 1}, 5)); // 5
        System.out.println(solution(new int[]{1, 2, 3, -3, 1, 2, 2, -3}, 5)); // 5
        System.out.println(solution(new int[]{1, 2, 3, -3, 1, 2}, 3)); // 6
        System.out.println(solution(new int[]{-1, 0, 1}, 0)); // 2
        System.out.println(solution(new int[]{-1, -1, -1, 1}, 0)); // 1
    }

    public static int solution(int[] nums, int m) {
        int answer = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == m) {
                    answer++;
                }
            }
        }

        return answer;
    }

}
