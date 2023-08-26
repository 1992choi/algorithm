package inflearn.lecture01.ex03;

import java.util.Scanner;

public class Ex03_01_02 {

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
        int indexN = 0;
        int indexM = 0;

        // 작은 수부터 출력
        while (indexN < n && indexM < m) {
            if (arrN[indexN] < arrM[indexM]) {
                System.out.print(arrN[indexN] + " ");
                indexN++;
            } else {
                System.out.print(arrM[indexM] + " ");
                indexM++;
            }
        }

        // 나머지 출력
        for (int i = indexN; i < n; i++) {
            System.out.print(arrN[i] + " ");
        }
        for (int i = indexM; i < m; i++) {
            System.out.print(arrM[i] + " ");
        }
    }

}