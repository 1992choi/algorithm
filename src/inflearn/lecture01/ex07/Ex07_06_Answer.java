package inflearn.lecture01.ex07;

public class Ex07_06_Answer {

    static int n;
    static int[] ch;

    public static void main(String[] args) {
        n = 3;
        ch = new int[n + 1];

        DFS(1);
    }

    public static void DFS(int level) {
        if (level == n + 1) {
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 1) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        } else {
            ch[level] = 1; // 좌측은 부분집합으로 사용
            DFS(level + 1); // 왼쪽 노드 탐색

            ch[level] = 0; // 우측은 부분집합으로 사용 안함
            DFS(level + 1); // 오른쪽 노드 탐색
        }
    }

}