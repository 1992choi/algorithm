package inflearn.lecture01.ex08;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex08_04_02 {

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        // 입력값 셋팅
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        // 탐색
        solution(n, m);
    }

    public static void solution(int n, int m) {
        for (int i = 1; i <= n; i++) {
            list = new ArrayList<>();
            list.add(i);
            dfs(n, m);
        }
    }

    public static void dfs(int n, int m) {
        if (list.size() == m) {
            for (int num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= n; i++) {
                list.add(i);
                dfs(n, m);
                list.remove(list.size() - 1);
            }
        }
    }

}