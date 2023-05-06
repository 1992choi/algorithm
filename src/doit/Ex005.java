package doit;

public class Ex005 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 1, 2}, 3)); // 7
    }

    public static int solution(int[] arr, int num) {
        int answer = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum % num == 0) {
                    answer++;
                }
            }
        }

        return answer;
    }

}
