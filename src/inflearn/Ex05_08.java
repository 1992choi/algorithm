package inflearn;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex05_08 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println(solution(n, m, arr)); // 오답
    }

    public static int solution(int n , int m, int[] arr) {
        int answer = 0;
        int target = arr[m];
        int sameCnt = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (i < m && arr[i] ==target) { // M번째 환자보다 앞에 있는 환자 중 위험도가 같은 환자 수 체크
                sameCnt++;
            }
            queue.offer(arr[i]);
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            int max = queue.stream().max(Comparator.naturalOrder()).get();
            if (tmp >= max) {
                count++;
                if (tmp == target) {
                    answer = count;
                    break;
                }
            } else {
                queue.offer(tmp);
            }
        }

        return answer + sameCnt;
    }

}