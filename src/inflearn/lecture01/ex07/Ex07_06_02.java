package inflearn.lecture01.ex07;

import java.util.Scanner;

public class Ex07_06_02 {

    static int n;
    static boolean[] visit;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        visit = new boolean[n + 1];

        dfs(1);
    }

    public static void dfs(int level) {
        if (level == n) {
            for (int i = 1; i < visit.length; i++) {
                if (visit[i]) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        } else {
            visit[level] = true;
            dfs(level + 1);

            visit[level] = false;
            dfs(level + 1);
        }
    }

}

