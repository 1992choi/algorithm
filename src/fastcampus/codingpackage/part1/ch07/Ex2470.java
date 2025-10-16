package fastcampus.codingpackage.part1.ch07;

import java.util.Arrays;
import java.util.Scanner;

public class Ex2470 {

    /*
        풀이
        - 주어진 값이 '-99 -80 -11 -10 -2 -1 6 75 89' 라고 가정.
        - '-99'와 'X'가 0과 가장 가까우려면 X는 0이어야한다.
          하지만 99가 없는 경우, 가장 가까운 용액을 구해야한다.
          이 때 시간복잡도를 낮추기위해서 이진탐색을 적용할 수 있다.

          L = -80 / R = 89 이면, 중앙값은 -2가 된다.
          (-99) + (-2)는 합이 음수이므로 최적이 될 수 있는 값은 -2보다 작은 값 중에는 존재하지 않을 것이다.
          그러므로 L을 (중앙값 + 1)로 이동 시킨다.   [ * 만약 합이 양수이면 R을 (중앙값 - 1)로 이동시킨다. ]
     */
    static int findNearestValue(int[] arr, int leftIndex, int rightIndex, int findValue) {
        int nearestValue = arr[leftIndex];
        int nearestDiff = Math.abs(findValue - nearestValue);
        int l = leftIndex + 1, r = rightIndex;
        while (l <= r) {
            int m = (l + r) / 2;
            int diff = Math.abs(findValue - arr[m]);
            if (diff < nearestDiff) {
                nearestValue = arr[m];
                nearestDiff = diff;
            }
            if (arr[m] < findValue) l = m + 1;
            else if (arr[m] > findValue) r = m - 1;
            else return findValue;
        }
        return nearestValue;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        Arrays.sort(arr);

        int ansAbs = Math.abs(arr[0] + arr[1]);
        int ans1 = arr[0];
        int ans2 = arr[1];
        for (int i = 0; i < N - 1; i++) {
            int pairValue = findNearestValue(arr, i + 1, N - 1, -arr[i]);
            int sumAbs = Math.abs(arr[i] + pairValue);
            if (ansAbs > sumAbs) {
                ansAbs = sumAbs;
                ans1 = arr[i];
                ans2 = pairValue;
            }
        }
        System.out.println(ans1 + " " + ans2);
    }

}