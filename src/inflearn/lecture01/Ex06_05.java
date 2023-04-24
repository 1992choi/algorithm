package inflearn.lecture01;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Ex06_05 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println(solution(n, arr));
    }

    public static String solution(int n, int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(arr[i]);
        }

        return set.size() == n ? "U" : "D";
    }

}