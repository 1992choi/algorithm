package doit;

public class Ex006 {

    public static void main(String[] args) {
        System.out.println(solution(10)); // 2
        System.out.println(solution(15)); // 4
    }

    public static int solution(int num) {
        int answer = 0;

        int[] arr = new int[num];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        int leftIdx = 0;
        int rightIdx = 1;

        while (leftIdx != num) {
            int sum = 0;
            for (int i = leftIdx; i < rightIdx; i++) {
                sum += arr[i];
            }
            if (sum == num) {
                answer++;
            }

            if (sum < num) {
                rightIdx++;
            } else {
                leftIdx++;
            }
        }

        return answer;
    }

}
