package inflearn;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Ex04_03 {

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

}
