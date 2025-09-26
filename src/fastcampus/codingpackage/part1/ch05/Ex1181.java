package fastcampus.codingpackage.part1.ch05;

import java.util.Arrays;
import java.util.Scanner;

public class Ex1181 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }

        Arrays.sort(words, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                for (int i = 0; i < o1.length(); i++) {
                    if (o1.charAt(i) != o2.charAt(i)) {
                        return o1.charAt(i) - o2.charAt(i);
                    }
                }
            }

            return o1.length() - o2.length();
        });

        System.out.println(words[0]);
        for (int i = 1; i < n; i++) {
            if (!words[i].equals(words[i - 1])) {
                System.out.println(words[i]);
            }
        }
    }

}

/*
    풀이
    - 내 풀이와 다른점
      - return o1.compareTo(o2); : 문자열은 사전순 정렬을 해주기 때문에 charAt으로 한 글자씩 비교할 필요가 없다.

    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    String[] words = new String[N];
    for (int i = 0; i < N; i++)
        words[i] = sc.next();

    Arrays.sort(words, new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            if (o1.length() == o2.length())
                return o1.compareTo(o2);
            return o1.length() - o2.length();
        }
    });

    System.out.println(words[0]);
    for (int i = 1; i < N; i++)
        if (!words[i].equals(words[i - 1]))
            System.out.println(words[i]);
 */