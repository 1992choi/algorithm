package inflearn.lecture01.ex04;

import java.util.*;

public class Ex04_05_02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println(solution(n, k, arr));
    }

    public static int solution(int n, int k, int[] arr) {
        int answer = -1;
        Set<Integer> set = new TreeSet<>(Comparator.reverseOrder());

        // 3장씩 뽑을 수 있는 모든 경우에 수 구하기
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int l = j + 1; l < n; l++) {
                    set.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }

        // k번째 큰 수 찾기
        int count = 1;
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            int sum = it.next();
            if (count == k) {
                return sum;
            }
            count++;
        }

        return answer;
    }

}