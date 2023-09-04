package inflearn.lecture01.ex04;

import java.util.*;

public class Ex04_03_02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        solution(n, k, arr);
    }

    public static void solution(int n, int k, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        // 0 ~ k 번 탐색
        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        System.out.print(map.size() + " ");

        // 나머지 탐색
        for (int i = k; i < n; i++) {
            // 범위에서 벗어난 1건에 대한 판단
            int prev = map.get(arr[i - k]);
            if (prev == 1) {
                map.remove(arr[i - k]);
            } else {
                map.put(arr[i - k], prev - 1);
            }

            // 신규 범위가 된 1건에 대한 판단
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            System.out.print(map.size() + " ");
        }
    }

}
