package fastcampus.codingpackage.part1.ch04;

import java.util.Arrays;
import java.util.Scanner;

public class Ex2840 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        char[] wheel = new char[N];
        Arrays.fill(wheel, '?');

        int curIndex = 0;
        while (K-- > 0) {
            int step = sc.nextInt();
            char nextAlphabet = sc.next().charAt(0);
            int nextIndex = ((curIndex - step) % N + N) % N; // N의 주기를 가지는 환형 구조는 %N을 통해 인덱스를 조정할 수 있다. (단, 음수 모듈러는 음의 나머지를 반환하기 때문에  +N을 해주고 다시 %N을 해줘서 양수로 변경하는 식의 계산법 필요.
            if (wheel[nextIndex] == '?') {
                wheel[nextIndex] = nextAlphabet;
            } else if (wheel[nextIndex] != nextAlphabet) { // 동일한 칸인데 다른 알파벳이 존재하게 되면 행운의 바퀴가 아닐 수 밖에 없음.
                System.out.println("!");
                return;
            }
            curIndex = nextIndex;
        }

        // 바퀴에 적힌 알파벳이 모두 다른지에 대한 검증
        boolean[] chk = new boolean[26];
        for (int i = 0; i < N; i++) {
            if (wheel[i] == '?') {
                continue;
            }
            if (chk[wheel[i] - 'A']) {
                System.out.println("!");
                return;
            }
            chk[wheel[i] - 'A'] = true;
        }

        // 마지막으로 도착한 글자부터 출력하기 위함
        for (int i = 0; i < N; i++) {
            System.out.print(wheel[(curIndex + i) % N]);
        }

        System.out.println();
    }

}