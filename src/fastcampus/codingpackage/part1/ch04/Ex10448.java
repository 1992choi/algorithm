package fastcampus.codingpackage.part1.ch04;

import java.util.Arrays;
import java.util.Scanner;

public class Ex10448 {

    public static void main(String[] args) {
        // 선 강의
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int maxArrValue = Arrays.stream(arr).max().getAsInt();
        int[] eurekaNumbers = new int[maxArrValue + 1];

        for (int i = 1; i <= maxArrValue; i++) {
            eurekaNumbers[i] = i * (i + 1) / 2;
        }

        for (int i = 0; i < n; i++) {
            int num = arr[i];
            boolean isEurekaNumber = false;

            for (int j = 1; j <= num; j++) {
                for (int k = 1; k <= num; k++) {
                    for (int l = 1; l <= num; l++) {
                        if (num == eurekaNumbers[j] + eurekaNumbers[k] + eurekaNumbers[l]) {
                            isEurekaNumber = true;
                            break;
                        }
                    }

                    if (isEurekaNumber) {
                        break;
                    }
                }

                if (isEurekaNumber) {
                    break;
                }
            }

            if (isEurekaNumber) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

}

/*
    풀이

    static boolean[] isEurekaNumber = new boolean[1001];

    public static void preprocess() {
        int[] triangleNumbers = new int[50];
        int triangleNumberCount = 0;
        for (int i = 1; ; i++) {
            int triangleNumber = i * (i + 1) / 2;
            if (triangleNumber > 1000) break;
            triangleNumbers[triangleNumberCount++] = triangleNumber;
        }

        for (int i = 0; i < triangleNumberCount; i++)
            for (int j = i; j < triangleNumberCount; j++)
                for (int k = j; k < triangleNumberCount; k++) {
                    int eurekaNumber = triangleNumbers[i] + triangleNumbers[j] + triangleNumbers[k];
                    if (eurekaNumber > 1000) break;
                    isEurekaNumber[eurekaNumber] = true;
                }
    }

    public static void main (String[] args) {
        preprocess();

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int K = sc.nextInt();
            System.out.println(isEurekaNumber[K] ? "1" : "0");
        }
    }

 */