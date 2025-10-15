package fastcampus.codingpackage.part1.ch07;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Ex2295 {

    public static void main(String[] args) {
        // 메모리 초과
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            set.add(arr[i]);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (set.contains(arr[i] + arr[j] + arr[k])) {
                        max = Math.max(max, arr[i] + arr[j] + arr[k]);
                    }
                }
            }
        }

        System.out.println(max);
    }

}

/*
    풀이
    - 세 수를 고르는 모든 경우의 수로 판단하면, 시간 초과
      그렇기 때문에 식을 변형하여 세 수의 조합이 아닌 두 수를 조합하는 형태로 시간복잡도를 줄일 수 있다.
        Ex) 'A + B + C = X' 가 아닌 'A + B = X - C' 의 형태. (즉 A + B를 미리 구해놓으면 반복문 중첩을 조금 줄일 수 있다.)
      또한, 이분탐색을 활용하여 탐색하는 범위도 줄이는 방법도 결합하여 더 효율적으로 구할 수 있다.

    static boolean isExist(int[] arr, int x) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] < x) l = m + 1;
            else if (arr[m] > x) r = m - 1;
            else return true;
        }
        return false;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        // 두 수의 조합을 미리 구하기.
        int[] sums = new int[N * (N + 1) / 2];
        int sumIndex = 0;
        for (int i = 0; i < N; i++)
            for (int j = i; j < N; j++)
                sums[sumIndex++] = arr[i] + arr[j];

        // 이분 탐색을 위한 정렬
        Arrays.sort(sums);

        int ans = -1;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                int target = arr[i] - arr[j];

                // 이분 탐색 활용
                if (isExist(sums, target))
                    ans = Math.max(ans, arr[i]);
            }
        System.out.println(ans);
    }
 */