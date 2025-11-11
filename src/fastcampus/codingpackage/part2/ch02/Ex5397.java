package fastcampus.codingpackage.part2.ch02;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Ex5397 {

    public static void main(String[] args) {
        /*
            풀이
            - 커서의 위치를 기준으로 문자열을 양쪽으로 나누어 관리한다.
            - 커서 왼쪽은 beforCursor, 오른쪽은 afterCursor 스택(Deque)으로 구성한다.

            1. 입력 명령을 순서대로 처리하며 다음과 같이 동작한다.
               - 문자 입력: 커서 왼쪽(beforCursor)에 추가
               - '<': 커서를 왼쪽으로 이동 (beforCursor → afterCursor)
               - '>': 커서를 오른쪽으로 이동 (afterCursor → beforCursor)
               - '-': 커서 왼쪽 문자 삭제 (beforCursor의 마지막 제거)

            2. 모든 입력 처리가 끝나면
               - beforCursor의 내용을 순서대로 출력하고
               - afterCursor의 내용을 역순으로 출력한다.

            3. Deque을 사용하면 각 명령 처리를 O(1)에 수행할 수 있다.

            [예시]
            입력: ABC<<DE
            처리 과정:
                A 입력 → beforCursor = [A]
                B 입력 → beforCursor = [A, B]
                C 입력 → beforCursor = [A, B, C]
                '<'   → C를 오른쪽으로 이동 → beforCursor = [A, B], afterCursor = [C]
                '<'   → B를 오른쪽으로 이동 → beforCursor = [A], afterCursor = [C, B]
                D 입력 → beforCursor = [A, D]
                E 입력 → beforCursor = [A, D, E]

            출력:
                beforCursor 순서대로 출력 → A D E
                afterCursor 역순으로 출력 → B C
                최종 결과: ADEBC
        */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            char[] input = sc.next().toCharArray();
            Deque<Character> beforCursor = new ArrayDeque<>();
            Deque<Character> afterCursor = new ArrayDeque<>();
            for (char cmd : input) {
                if (cmd == '-') {
                    beforCursor.pollLast();
                } else if (cmd == '<') {
                    if (!beforCursor.isEmpty())
                        afterCursor.offerLast(beforCursor.pollLast());
                } else if (cmd == '>') {
                    if (!afterCursor.isEmpty())
                        beforCursor.offerLast(afterCursor.pollLast());
                } else {
                    beforCursor.offerLast(cmd);
                }
            }

            StringBuilder sb = new StringBuilder();
            while (!beforCursor.isEmpty()) sb.append(beforCursor.pollFirst());
            while (!afterCursor.isEmpty()) sb.append(afterCursor.pollLast());
            System.out.println(sb);
        }
    }

}