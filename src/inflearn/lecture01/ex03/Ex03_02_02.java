package inflearn.lecture01.ex03;

import java.util.Arrays;
import java.util.Scanner;

public class Ex03_02_02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arrN = new int[n];
        for (int i = 0; i < n; i++) {
            arrN[i] = in.nextInt();
        }

        int m = in.nextInt();
        int[] arrM = new int[m];
        for (int i = 0; i < m; i++) {
            arrM[i] = in.nextInt();
        }

        solution(n, arrN, m, arrM);
    }

    public static void solution(int n, int[] arrN, int m, int[] arrM) {
        Arrays.sort(arrN);
        Arrays.sort(arrM);

        int indexN = 0;
        int indexM = 0;

        while (indexN < n && indexM < m) {
            if (arrN[indexN] == arrM[indexM]) {
                System.out.print(arrN[indexN] + " ");
                indexN++;
                indexM++;
            } else if (arrN[indexN] > arrM[indexM]) {
                indexM++;
            } else if (arrN[indexN] < arrM[indexM]) {
                indexN++;
            }
        }
    }

}