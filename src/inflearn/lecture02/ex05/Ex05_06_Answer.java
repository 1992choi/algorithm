package inflearn.lecture02.ex05;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Ex05_06_Answer {

    public static void main(String[] args) {
        System.out.println(solution(5, new int[][]{{1, 4, 2}, {2, 5, 1}}, new int[][]{{1, 2}, {1, 5}, {2, 3}, {2, 4}, {2, 5}, {2, 5}, {3, 5}, {3, 4}})); // 5
        System.out.println(solution(5, new int[][]{{2, 3, 1}, {1, 5, 1}}, new int[][]{{2, 5}, {1, 5}, {1, 3}, {2, 4}, {2, 5}, {2, 3}})); // 2
        System.out.println(solution(8, new int[][]{{1, 8, 3}, {3, 8, 1}}, new int[][]{{1, 3}, {5, 8}, {2, 7}, {3, 8}, {2, 7}, {2, 8}, {3, 8}, {6, 8}, {7, 8}, {5, 8}, {2, 5}, {2, 7}, {3, 7}, {3, 8}})); // 7
        System.out.println(solution(9, new int[][]{{1, 8, 3}, {3, 9, 2}, {1, 5, 3}}, new int[][]{{1, 9}, {5, 8}, {2, 9}, {3, 8}, {2, 9}, {1, 9}, {8, 9}, {3, 9}, {1, 8}, {6, 8}, {7, 8}, {5, 8}, {3, 5}, {3, 7}, {4, 7}, {5, 8}})); // 8
        System.out.println(solution(9, new int[][]{{2, 7, 2}, {3, 9, 2}, {1, 5, 3}}, new int[][]{{1, 9}, {4, 8}, {2, 9}, {5, 9}, {3, 8}, {2, 9}, {1, 9}, {8, 9}, {3, 9}, {1, 8}, {6, 8}, {3, 6}, {7, 8}, {5, 8}, {3, 5}, {2, 7}, {1, 7}, {2, 8}})); // 7
    }

    public static int solution(int n, int[][] trans, int[][] bookings) {
        int answer = 0;
        int[] sum = new int[n + 1];
        for (int[] x : trans) {
            sum[x[0]] += x[2];
            sum[x[1]] -= x[2];
        }
        for (int i = 1; i <= n; i++) {
            sum[i] += sum[i - 1];
        }
        int bN = bookings.length;
        Arrays.sort(bookings, (a, b) -> a[0] - b[0]);
        LinkedList<Integer> nums = new LinkedList<>();
        int ix = 0;
        for (int i = 1; i <= n; i++) {
            while (!nums.isEmpty() && nums.peek() == i) {
                answer++;
                nums.pollFirst();
            }
            while (ix < bN && bookings[ix][0] == i) {
                nums.add(bookings[ix][1]);
                ix++;
            }
            Collections.sort(nums);
            while (nums.size() > sum[i]) {
                nums.pollLast();
            }
        }
        return answer;
    }

}
