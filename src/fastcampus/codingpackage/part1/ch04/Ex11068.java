package fastcampus.codingpackage.part1.ch04;

import java.util.Scanner;

public class Ex11068 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] arr = new int[t];

        for (int i = 0; i < t; i++) {
            arr[i] = sc.nextInt();
        }

        char[] digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz+/".toCharArray();

        for (int i = 0; i < t; i++) {
            int num = arr[i];
            boolean isEqual = false;

            for (int base = 2; base <= 64; base++) {
                int n = num;
                StringBuilder sb = new StringBuilder();

                while (n > 0) {
                    sb.append(digits[n % base]);
                    n /= base;
                }

                String converted = sb.reverse().toString();
                String reversed = new StringBuilder(converted).reverse().toString();

                if (converted.equals(reversed)) {
                    isEqual = true;
                    break;
                }
            }

            System.out.println(isEqual ? 1 : 0);
        }
    }

}