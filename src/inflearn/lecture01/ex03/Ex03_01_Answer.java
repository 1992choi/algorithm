package inflearn.lecture01.ex03;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex03_01_Answer {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr1Count = in.nextInt();
        int[] arr1 = new int[arr1Count];
        for (int i = 0; i < arr1Count; i++) {
            arr1[i] = in.nextInt();
        }

        int arr2Count = in.nextInt();
        int[] arr2 = new int[arr2Count];
        for (int i = 0; i < arr2Count; i++) {
            arr2[i] = in.nextInt();
        }

        solution(arr1Count, arr1, arr2Count, arr2);
    }

    public static void solution(int n, int[] a, int m, int[] b) {
        ArrayList<Integer> answer = new ArrayList();
        int p1 = 0;
        int p2 = 0;

        while (p1 < n && p2 < m) {
            if (a[p1] < b[p2]) {
                answer.add(a[p1++]);
            } else {
                answer.add(b[p2++]);
            }
        }

        while (p1 < n) {
            answer.add(a[p1++]);
        }

        while (p2 < m) {
            answer.add(b[p2++]);
        }

        System.out.println(answer);
    }

}