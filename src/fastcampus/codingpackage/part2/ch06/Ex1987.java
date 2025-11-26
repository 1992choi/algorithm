package fastcampus.codingpackage.part2.ch06;

import java.util.Scanner;

/*
  풀이
  - 시작점에서부터 상하좌우로 이동하며, 이미 사용한 알파벳은 다시 밟지 않는 조건으로 DFS를 수행한다
  - 사용한 알파벳은 check 배열로 관리하고, (row, col)에 어떤 알파벳 조합(bitmask)으로 도달했는지를 visited에 기록한다
  - 동일한 칸이어도 "똑같은 알파벳 조합(bitmask)"으로 이미 방문했다면 더 탐색할 필요가 없으므로 가지치기한다
  - 모든 경로 중 가장 긴 이동 길이를 찾는 전형적인 백트래킹 + 비트마스크 최적화 문제
*/
class Ex1987 {
    public static int[][] board;
    public static boolean[] check = new boolean[26];
    public static int r, c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        board = new int[r][c];
        visited = new int[r][c];

        for (int i = 0; i < r; i++) {
            String line = sc.next();
            for (int j = 0; j < c; j++) {
                board[i][j] = line.charAt(j) - 'A';
            }
        }

        visited[0][0] = 1 << board[0][0];
        check[board[0][0]] = true;

        System.out.println(solve(0, 0));
    }

    // 상 우 하 좌
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    // visited[row][col] → (row, col)에 도달했을 때 사용한 알파벳 bitmask 저장
    //   - 예: A(0), C(2), F(5)를 사용했다면 bitmask는 0001 0010 0101 형태
    //   - 같은 칸이라도 같은 bitmask로 다시 왔다면 더 긴 경로가 될 가능성이 없으므로 탐색을 중단한다
    //   - 즉, visited는 "이 경로 상태로 이 칸에 와본 적 있음"을 기록해 불필요한 DFS 분기를 차단한다
    public static int[][] visited;

    public static int solve(int row, int col) {
        int result = 0;

        for (int d = 0; d < 4; d++) {
            int nr = row + dr[d];
            int nc = col + dc[d];

            if (isOutOfBound(nr, nc, r, c)) continue;

            int next = board[nr][nc];
            if (check[next]) continue; // 알파벳 중복 금지

            // 현재 칸에서 next 알파벳을 포함해 이동했을 때의 비트마스크(newMask)를 계산한다.
            // 만약 (nr, nc)에 이전에 도달했을 때의 비트마스크와 newMask가 동일하다면,
            // 이미 같은 알파벳 조합으로 이 칸을 탐색한 적이 있다는 의미이므로
            // 이후 경로 탐색 결과도 달라질 것이 없어 중복 탐색을 방지하기 위해 가지치기한다.
            int bit = 1 << next;
            if (visited[nr][nc] == (visited[row][col] | bit)) continue;

            visited[nr][nc] = visited[row][col] | bit;
            check[next] = true;

            int depth = solve(nr, nc);
            result = Math.max(result, depth);

            check[next] = false; // 백트래킹
        }

        return result + 1; // 현재 칸 포함
    }

    static boolean isOutOfBound(int row, int col, int boundR, int boundC) {
        return row < 0 || col < 0 || row >= boundR || col >= boundC;
    }
}
