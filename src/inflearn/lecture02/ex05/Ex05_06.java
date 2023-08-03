package inflearn.lecture02.ex05;

import java.util.*;

public class Ex05_06 {

    public static void main(String[] args) {
        /**
         *  문제해법 보고 푼 문제.
         */
        System.out.println(solution(5, new int[][]{{1, 4, 2}, {2, 5, 1}}, new int[][]{{1, 2}, {1, 5}, {2, 3}, {2, 4}, {2, 5}, {2, 5}, {3, 5}, {3, 4}})); // 5
        System.out.println(solution(5, new int[][]{{2, 3, 1}, {1, 5, 1}}, new int[][]{{2, 5}, {1, 5}, {1, 3}, {2, 4}, {2, 5}, {2, 3}})); // 2
        System.out.println(solution(8, new int[][]{{1, 8, 3}, {3, 8, 1}}, new int[][]{{1, 3}, {5, 8}, {2, 7}, {3, 8}, {2, 7}, {2, 8}, {3, 8}, {6, 8}, {7, 8}, {5, 8}, {2, 5}, {2, 7}, {3, 7}, {3, 8}})); // 7
        // TODO: 2023/06/08 해당 케이스 오류 발생 :  System.out.println(solution(9, new int[][]{{1, 8, 3}, {3, 9, 2}, {1, 5, 3}}, new int[][]{{1, 9}, {5, 8}, {2, 9}, {3, 8}, {2, 9}, {1, 9}, {8, 9}, {3, 9}, {1, 8}, {6, 8}, {7, 8}, {5, 8}, {3, 5}, {3, 7}, {4, 7}, {5, 8}})); // 8
        System.out.println(solution(9, new int[][]{{2, 7, 2}, {3, 9, 2}, {1, 5, 3}}, new int[][]{{1, 9}, {4, 8}, {2, 9}, {5, 9}, {3, 8}, {2, 9}, {1, 9}, {8, 9}, {3, 9}, {1, 8}, {6, 8}, {3, 6}, {7, 8}, {5, 8}, {3, 5}, {2, 7}, {1, 7}, {2, 8}})); // 7
    }

    public static int solution(int n, int[][] trans, int[][] bookings) {
        int answer = 0;

        // 역에서 탈 수 있는 최대 인원수 구하기
        int[] sum = new int[n + 1];
        for (int[] tran : trans) {
            sum[tran[0]] = tran[2];
            sum[tran[1]] = -tran[2];
        }
        for (int i = 1; i < n + 1; i++) {
            sum[i] += sum[i - 1];
        }

        // 승차역이 빠른 순으로 정렬
        Arrays.sort(bookings, Comparator.comparingInt(x -> x[0]));

        // 기차 탑승 계산하기
        List<Integer> train = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            // 하차하는 어린이 구하기
            while (train.contains(i)) {
                train.remove(Integer.valueOf(i));
                answer++;
            }

            // 승차하는 어린이 구하기 (i와 승차역이 같은 어린이 태우기)
            int j = 0;
            while (j < bookings.length) {
                if (i == bookings[j][0]) {
                    train.add(bookings[j][1]);
                }
                j++;
            }
            // 정렬
            Collections.sort(train);

            // 탑승 인원이 초과했을 경우, 멀리가는 어린이 하차시키기
            while (sum[i] < train.size()) {
                train.remove(train.size() - 1);
            }
        }

        return answer;
    }

}
