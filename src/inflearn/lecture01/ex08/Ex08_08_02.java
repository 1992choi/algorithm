package inflearn.lecture01.ex08;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Time Limit Exceeded
 */
public class Ex08_08_02 {

    static String answer = "";
    static int n;
    static int f;
    static int[] arr;
    static boolean[] isUse;

    public static void main(String[] args) {
        // 입력값 셋팅
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        f = in.nextInt();
        isUse = new boolean[n];
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        // 탐색 - 순열 구하기
        dfs(0, 0);
        System.out.println(answer);
    }

    public static void dfs(int level, int r) {
        if (!"".equals(answer)) { // 답이 여러개라면 가장 먼저 찾은 수열로 리턴하기 위함
            return;
        }

        if (level == n) {
            // 역삼각형 윗변 셋팅
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(arr[i] + 1);
            }
            int tmp = n; // 역삼각형의 윗변의 숫자 갯수

            // 아랫변까지 연산하기
            while (tmp != 1) {
                // 현재 라인의 숫자 더해서 다음 라인의 합계 구하기
                int currentSize = list.size();
                for (int i = 0; i < currentSize - 1; i++) {
                    list.add(list.get(i) + list.get(i + 1));
                }

                // 이전 단계에서 다음 단계의 합계가 다 구해졌다면 이전 단계의 라인 제거하기
                list = list.subList(tmp, list.size());
                tmp--;
            }

            if (list.get(0) == f) {
                for (int i = 0; i < n; i++) {
                    answer += (arr[i] + 1) + " ";
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (!isUse[i]) {
                    isUse[i] = true;
                    arr[level] = i;
                    dfs(level + 1, i);
                    isUse[i] = false;
                }
            }
        }
    }

}