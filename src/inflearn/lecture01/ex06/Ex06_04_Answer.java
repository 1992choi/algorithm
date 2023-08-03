package inflearn.lecture01.ex06;

import java.util.Scanner;

public class Ex06_04_Answer {

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
        int[] cache = new int[s];
        for (int x : arr) {
            int pos = -1;
            for (int i = 0; i < s; i++) { // hit 여부 확인
                if (x == cache[i]) {
                    pos = i;
                }
            }

            if (pos == -1) { // mis
                for (int i = s - 1; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
            } else { // hit
                for (int i = pos; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
            }
            cache[0] = x;
        }

        for (int i : cache) {
            System.out.print(i + " ");
        }
    }

}