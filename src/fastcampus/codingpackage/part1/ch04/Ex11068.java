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

/*
    풀이
    - 64진법에서는 숫자, 소문자, 대문자를 모두 사용하여도 62번째와 63번째가 남아서 별도의 문자가 필요하다.
      하지만, 회문인 수의 특징을 생각해보면 문자열을 매핑하지 않아도 된다.
        - 대칭적인 특징을 이용하여 digit[i]과 digit[len - i - 1] 이 같은지만 확인하면 된다.
      진법을 표시할 때, 10진수의 자릿값을 그대로 사용하면 된다.
        - 64진법이라고 가정할 때, 각 자리를 아래와 같이 분리할 수 있다.
          (11 * 63의 3승) + (62 * 63의 2승) + (62 * 63의 1승) + (11 * 63의 0승)
          --> 11, 62, 62, 11 만 가지고 회문인 수인지 판단가능.

    public static boolean isPalindromeInBase(int x, int base) {
        int[] digit = new int[20];
        int len = 0;
        while (x > 0) {
            digit[len++] = x % base;
            x /= base;
        }

        for (int i = 0; i < len / 2; i++)
            if (digit[i] != digit[len - i - 1])
                return false;
        return true;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int x = sc.nextInt();
            boolean ans = false;
            for (int i = 2; i <= 64; i++) {
                if (isPalindromeInBase(x, i)) {
                    ans = true;
                    break;
                }
            }
            System.out.println(ans ? 1 : 0);
        }
    }
 */