package fastcampus.codingpackage.part1.ch03;

import java.util.Arrays;
import java.util.Scanner;

public class Ex3273 {

    public static void main(String[] args) {
        // 입력값 셋팅
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] number = new int[n];
        for (int i = 0; i < n; i++) {
            number[i] = sc.nextInt();
        }
        int x = sc.nextInt();

        // ai + aj = x를 만족하는 쌍의 수를 구하기
        int answer = 0;

        // 시간초과
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                if (number[i] + number[j] == x) {
//                    answer++;
//                }
//            }
//        }

        // 정답
        Arrays.sort(number);
        for (int i = 0; i < n; i++) {
            if (number[i] >= x) {
                break;
            }

            for (int j = i + 1; j < n; j++) {
                if (number[i] + number[j] > x) {
                    break;
                } else if (number[i] + number[j] == x) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

}
// 풀이
/*
    쌍을 모두 구하기 위해서는 이중 반복문을 사용해야한다.
    그렇게 되면 시간초과가 될 수 있기 때문에, 모든 쌍을 구하는 것이 아니라
    a[i] + a[j] = X의 성질을 이용하여, a[i]를 선택했을 때 X - a[i]의 값이 배열에 있는지 확인하는 식으로 접근을 할 수 있다.

    마지막에 ans를 2로 나누는 이유
    - 아래의 코드에서는 4을 만족하는 쌍이 (1, 3)와 (3, 1)이 모두 카운트된다.
      또한 2가 하나여도 (2, 2)가 카운팅된다.
      이 때 2를 나눠줌으로써 같은 수를 두 번 사용하는 경우와 중복으로 쌍이 카운팅된걸 제거할 수 있다.



    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] a = new int[N];
    for (int i = 0; i < N; i++)
        a[i] = sc.nextInt();
    int X = sc.nextInt();

    boolean[] exist = new boolean[1000001];
    for (int i = 0; i < N; i++)
        exist[a[i]] = true;

    long ans = 0;
    for (int i = 0; i < N; i++) {
        int pairValue = X - a[i];
        if (0 <= pairValue && pairValue <= 1000000) {
            ans += exist[pairValue] ? 1 : 0;
        }
    }
    System.out.println(ans / 2);
 */