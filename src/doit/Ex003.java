package doit;

public class Ex003 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{5, 4, 3, 2, 1}, 1, 3)); // 12
        System.out.println(solution(new int[]{5, 4, 3, 2, 1}, 2, 4)); // 9
        System.out.println(solution(new int[]{5, 4, 3, 2, 1}, 5, 5)); // 1
    }

    public static int solution(int[] arr, int start, int end) {
        int[] sumArr = new int[arr.length + 1]; // 구간합 배열

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sumArr[i + 1] = sum += arr[i];
        }

        return sumArr[end] - sumArr[start - 1];
    }

}
