package inflearn.lecture02;

public class Ex01_05 {

    public static void main(String[] args) {
        // CASE 1.
        System.out.println(solution(new int[]{1, 3, 2, 5, 7, 4, 2, 5, 1})); // 5

        // CASE 2.
        System.out.println(solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2})); // 8

        // CASE 3.
        System.out.println(solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1})); // 6

        // CASE 4.
        System.out.println(solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1})); // 5
    }

    public static int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            int status = 0; // 1=증가중 / 2=감소중 / 3=증->감 후 다시 증가
            int count = 1;

            for (int j = i; j < nums.length - 1; j++) {
                if (status == 0 && nums[j] < nums[j + 1]) {
                    count++;
                    status = 1;
                } else if (status == 1 && nums[j] < nums[j + 1]) {
                    count++;
                } else if (status == 1 && nums[j] > nums[j + 1]) {
                    count++;
                    status = 2;
                } else if (status == 2 && nums[j] > nums[j + 1]) {
                    count++;
                } else if (status == 2 && nums[j] <= nums[j + 1]) {
                    status = 3;
                }
            }

            answer = Math.max(answer, count);
        }

        return answer;
    }

}
