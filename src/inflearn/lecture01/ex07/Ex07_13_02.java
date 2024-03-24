package inflearn.lecture01.ex07;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 문제해법 보고 푼 문제.
 */
public class Ex07_13_02 {

    static int n;
    static int m;
    static int answer;
    static int[] check;
    static List<Integer>[] listArr;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        check = new int[n + 1];

        listArr = new List[m + 1];
        for (int i = 1; i <= m; i++) {
            int idx = in.nextInt();
            int value = in.nextInt();
            if (listArr[idx] == null) {
                listArr[idx] = new ArrayList();
            }

            listArr[idx].add(value);
        }


        // 1번부터 5번 정점까지 가지 수 확인
        check[1] = 1;
        dfs(1);

        System.out.println(answer);
        /*
            - 입력 값
                5 9
                1 2
                1 3
                1 4
                2 1
                2 3
                2 5
                3 4
                4 2
                4 5
         */
    }

    public static void dfs(int v) {
        if (v == n) {
            answer++;
        } else {
            for (int next : listArr[v]) {
                if (check[next] == 0) {
                    check[next] = 1;
                    dfs(next); // v에서 i로 탐색
                    check[next] = 0;
                }
            }
        }
    }

}

