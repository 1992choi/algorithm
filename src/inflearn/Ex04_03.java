package inflearn;

import java.util.*;

public class Ex04_03 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        // solution(n, k, arr); // Time out
        solution2(n, k, arr);
    }

    public static void solution(int n, int k, int[] arr) {
        int lt = 0;
        int rt = k;

        while (rt != n + 1) {
            Set<Integer> set = new HashSet<>();
            for (int i = lt; i < rt; i++) {
                set.add(arr[i]);
            }
            System.out.print(set.size() + " ");
            lt++;
            rt++;
        }
    }

    public static void solution2(int n, int k, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int lt = 0;
        int rt = k;

        // 초기 구성
        for (int i = lt; i < rt; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        System.out.print(map.size() + " ");

        // 슬라이드
        for (int i = rt; i < n; i++) {
            int leftValue = arr[i - k];
            int rightValue = arr[i];

            if (map.getOrDefault(leftValue, 0) <= 1) {
                map.remove(leftValue);
            } else {
                map.put(leftValue, map.get(leftValue) - 1);
            }
            map.put(rightValue, map.getOrDefault(rightValue, 0) + 1);

            System.out.print(map.size() + " ");
        }
    }

}
