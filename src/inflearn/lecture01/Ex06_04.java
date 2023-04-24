package inflearn.lecture01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex06_04 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        solution(s, n, arr);
    }

    public static void solution(int s, int n, int[] arr) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (list.contains(arr[i])) {
                list.remove(new Integer(arr[i]));
            }
            list.add(0, arr[i]);
        }

        for (int i = 0; i < s; i++) {
            System.out.print(list.get(i) + " ");
        }
    }

}