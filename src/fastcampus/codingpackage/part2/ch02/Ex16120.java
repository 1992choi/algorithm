package fastcampus.codingpackage.part2.ch02;

import java.util.Scanner;

public class Ex16120 {

    public static void main(String[] args) {
        /*
            풀이
            - P를 PPAP로 변경했을 때, 입력값과 동일한지 판단하는 접근 방법은 경우의 수가 너무 많아 비효율적인 접근 방법이다.
            - 생각을 전환하여, 입력값을 반대로 P로 만드는 방법으로 접근한다.
            - 이를 위해 스택을 사용할 수 있다. (단순하게 배열과 인덱스를 관리하여 풀 수도 있다.)

            Ex. PPPAPAP
            - P 판단
            - PP 판단
            - PPPA 판단
            - PPPAP 판단 : PPAP는 P로 변환가능하니 P'PPAP'를 지우고 'P'를 스택에 넣는다.
                          이때 PPAP를 빼고 P를 넣는 것과 PAP만 빼는 것과 결과는 동일하게 때문에 PPAP 중에 PAP만 제거한다. (len -= 3; 연산)
         */
        Scanner sc = new Scanner(System.in);

        char[] input = sc.next().toCharArray();
        char[] rewind = new char[input.length];
        int len = 0;
        for (char ch : input) {
            rewind[len++] = ch;
            if (len >= 4 && rewind[len - 1] == 'P' && rewind[len - 2] == 'A' && rewind[len - 3] == 'P' && rewind[len - 4] == 'P')
                len -= 3;
        }
        System.out.println(len == 1 && rewind[0] == 'P' ? "PPAP" : "NP");
    }

}