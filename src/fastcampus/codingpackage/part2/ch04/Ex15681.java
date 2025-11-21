package fastcampus.codingpackage.part2.ch04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
    풀이
    1. 반복되는 탐색이 되지 않도록 check 배열을 통해 방문여부를 기록
    2. {i}를 루트로 하는 서브 트리 노드의 합은 1로 초기화하고 탐색을 진행.
       - 정점의 수를 계산할 때, 자기 자신도 포함되어야하므로 최소 1이기 때문에 1로 설정
    3. child를 루트로 하는 노드의 수를 재귀로 구한다
       3.1. 해당 값이 이미 구해졌다면 sum[] 으로부터 획득
*/
class Ex15681 {

    static List<Integer>[] tree;
    static boolean[] check;
    static int[] sum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), r = sc.nextInt(), q = sc.nextInt();
        check = new boolean[n + 1];
        sum = new int[n + 1];
        tree = new ArrayList[n + 1];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt(), v = sc.nextInt();
            tree[u].add(v);
            tree[v].add(u);
        }
        sum[r] = getSum(r);
        for (int i = 0; i < q; i++) {
            int u = sc.nextInt();
            System.out.println(sum[u]);
        }
    }

    public static int getSum(int node) {
        if (sum[node] != 0) return sum[node]; // 3.1에 해당
        check[node] = true; // 1에 해당
        int result = 1; // 2에 해당
        for (int child : tree[node]) {
            if (!check[child]) {
                result += getSum(child); // 3에 해당
            }
        }
        return sum[node] = result;
    }

}
