package inflearn.lecture01.ex09;

import java.util.Scanner;

/**
 * 문제해법 보고 푼 문제.
 */
public class Ex09_06_02 {

    static int[] unf; // 서로소 집합을 담을 변수. 인덱스번호=학생번호, 값=소속된 집합의 번호

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        unf = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            unf[i] = i;
        }

        for (int i = 1; i <= m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            union(a, b); // a와 b는 친구관계이므로 한 개의 집합으로 만들기 위한 메서드
        }

        int a = kb.nextInt();
        int b = kb.nextInt();
        int fa = find(a);
        int fb = find(b);

        if (fa == fb) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static int find(int v) {
        if (v == unf[v]) {
            return unf[v];
        } else {
            return unf[v] = find(unf[v]);
        }
    }

    public static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);

        if (fa != fb) { // a와 b는 친구관계인데, 만약 현재 집합번호가 다르다면 집합번호를 같게 만드는 작업
            unf[fa] = fb;
        }
    }

}