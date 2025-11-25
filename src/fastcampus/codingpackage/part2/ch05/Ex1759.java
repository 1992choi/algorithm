package fastcampus.codingpackage.part2.ch05;

import java.util.Arrays;
import java.util.Scanner;

/*
    풀이
    - 길이가 L인 암호를 만들 때 모음 최소 1개, 자음 최소 2개 조건을 만족하도록 모든 조합 생성
    - 입력 문자를 정렬 후 재귀를 사용하여 사전 순으로 조합 생성
    - 재귀에서 각 문자 선택/비선택을 처리하며 조건 충족 시 출력
*/
class Ex1759 {
    static int l, c;
    static char[] input;
    static char[] password;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        l = sc.nextInt(); // 암호 길이
        c = sc.nextInt(); // 문자 개수

        input = new char[c];
        password = new char[l];
        for (int i = 0; i < c; i++) {
            input[i] = sc.next().charAt(0);
        }
        Arrays.sort(input); // 사전 순 출력을 위해 정렬
        generate(0, 0, 0);
    }

    static void generate(int length, int index, int vowelCnt) {
        // base case: 암호 길이 만족 시
        if (length == l) {
            if (vowelCnt >= 1 && l - vowelCnt >= 2) { // 조건 충족 여부 확인
                System.out.println(password);
            }
            return;
        }

        // recursive case: index 범위 내에서
        if (index < c) {
            // 현재 문자를 사용하는 경우
            password[length] = input[index];
            int v = isVowel(input[index]) ? 1 : 0;
            generate(length + 1, index + 1, vowelCnt + v);

            // 현재 문자를 사용하지 않는 경우
            password[length] = 0; // 없어도 되는 부분. (명시적으로 해당 값을 사용하지 않는다고 마킹하기 위한 코드. 없어도 동작하는데는 차이없음)
            generate(length, index + 1, vowelCnt);
        }
    }

    static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
