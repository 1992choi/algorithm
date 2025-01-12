package fastcampus.codingpackage.part1;

import java.util.Scanner;

// https://www.acmicpc.net/problem/1543
public class Ex004 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String targetValue = scanner.nextLine();
        String searchVal = scanner.nextLine();
        int answer = 0;

        while (targetValue.contains(searchVal)) {
            targetValue = targetValue.replaceFirst(searchVal, "#"); // 문자가 치환됨으로써 결합된 문자가 조건을 만족하지 못하게 하기 위함.
            answer++;
        }

        System.out.println(answer);
    }

}

// 풀이 1
/*
class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String doc = sc.nextLine();
        String word = sc.nextLine();
        int startIndex = 0;
        int count = 0;
        while (true) {
            int findIndex = doc.indexOf(word, startIndex);
            if (findIndex < 0)
                break;
            startIndex = findIndex + word.length();
            count++;
        }

        System.out.println(count);
    }
}
*/

// 풀이 2
/*
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String doc = sc.nextLine();
        String word = sc.nextLine();

        String replaced = doc.replaceAll(word, "");
        int length = doc.length() - replaced.length();
        int count = length / word.length();

        System.out.println(count);
    }
}
*/
