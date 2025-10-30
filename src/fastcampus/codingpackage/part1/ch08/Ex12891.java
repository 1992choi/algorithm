package fastcampus.codingpackage.part1.ch08;

import java.util.Scanner;

public class Ex12891 {

    public static void main(String[] args) {
        /*
            풀이
            - DNA 문자열이 길이 S이고, 부분 문자열의 길이가 P일 때
              매번 P길이의 부분문자열을 잘라서 조건을 확인하면 시간복잡도는 O(S*P)가 되어 비효율적이다.

              예시: "CCTGGATTG", P=4
                > "CCTG", "CTGG", "TGGA", "GGAT", "GATT", "ATTG" … 각 구간을 매번 새로 검사해야 함.

            - 이를 효율적으로 처리하기 위해 '슬라이딩 윈도우' 기법(=투 포인터)을 사용한다.
              1) 처음 P개의 문자를 윈도우에 넣고 각 문자의 등장 횟수를 카운트한다.
              2) 이후 한 칸씩 오른쪽으로 윈도우를 이동시키며:
                 - 왼쪽에서 빠지는 문자의 카운트를 1 감소시키고,
                 - 새로 들어오는 문자의 카운트를 1 증가시킨다.
              3) 매 이동 시마다 현재 카운트가 조건(minimumBaseCount)을 만족하는지 확인한다.

            - 이렇게 하면 모든 부분 문자열을 확인하더라도 O(S)로 해결할 수 있다.
        */
        Scanner sc = new Scanner(System.in);

        int S = sc.nextInt();
        int P = sc.nextInt();
        char[] sequence = sc.next().toCharArray();
        int[] minimumBaseCount = new int[4];
        for (int i = 0; i < 4; i++)
            minimumBaseCount[i] = sc.nextInt();

        int[] currentBaseCount = new int[4];
        for (int i = 0; i < P; i++)
            currentBaseCount[baseToIndex(sequence[i])]++;
        int ans = isValidSequence(currentBaseCount, minimumBaseCount) ? 1 : 0;

        for (int i = 1; i <= S - P; i++) {
            currentBaseCount[baseToIndex(sequence[i - 1])]--;
            currentBaseCount[baseToIndex(sequence[i + P - 1])]++;
            if (isValidSequence(currentBaseCount, minimumBaseCount))
                ans++;
        }
        System.out.println(ans);
    }

    static int baseToIndex(char alp) {
        if (alp == 'A') return 0;
        else if (alp == 'C') return 1;
        else if (alp == 'G') return 2;
        else if (alp == 'T') return 3;
        return -1;
    }

    static boolean isValidSequence(int[] baseCount, int[] minimumBaseCount) {
        for (int i = 0; i < baseCount.length; i++)
            if (baseCount[i] < minimumBaseCount[i])
                return false;
        return true;
    }

}