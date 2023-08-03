package inflearn.lecture01.ex04;

import java.util.*;

public class Ex04_05 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println(solution(n, k, arr));
    }

    public static int solution(int n, int k, int[] arr) {
        int answer = -1;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int l = j + 1; l < n; l++) {
                    set.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }

        if (set.size() >= k - 1) {
            Integer[] sumArr = set.toArray(new Integer[0]);
            Arrays.sort(sumArr, Comparator.reverseOrder());
            answer = sumArr[k - 1];
        }

        return answer;
    }

}