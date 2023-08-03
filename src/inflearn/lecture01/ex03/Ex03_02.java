package inflearn.lecture01.ex03;

import java.util.Arrays;
import java.util.Scanner;

public class Ex03_02 {

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

    public static void solution(int arr1Count, int[] arr1, int arr2Count, int[] arr2) {
        String answer = "";
        int arr1Point = 0;
        int arr2Point = 0;
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for (int i = 0; i < arr1Count + arr2Count; i++) {
            if (arr1[arr1Point] > arr2[arr2Point]) {
                arr2Point++;
            } else if (arr1[arr1Point] < arr2[arr2Point]) {
                arr1Point++;
            } else {
                answer += arr1[arr1Point] + " ";
                arr1Point++;
                arr2Point++;
            }

            if (arr1Point >= arr1Count || arr2Point >= arr2Count) {
                break;
            }

        }

        System.out.println(answer);
    }

}