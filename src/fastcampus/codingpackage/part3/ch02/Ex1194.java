package fastcampus.codingpackage.part3.ch02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
    풀이

    - 열쇠/문/출구가 있는 미로에서 BFS로 최단 거리 탐색
    - 상태는 (r, c, keyBitmask) 로 관리하며, keyBitmask는 최대 6개 열쇠 보유 상태를 비트로 저장
    - distance[r][c][key]: 해당 위치를 key 상태로 방문했을 때 걸린 거리 기록
    - 문(A~F)은 해당 키(a~f)가 keyBitmask에 있는 경우만 통과 가능
    - 키(a~f)는 획득 시 keyBitmask에 OR 연산으로 추가
    - 출구(1)에 도달하면 현재 거리 출력 후 종료
    - BFS가 끝날 때까지 출구에 도달하지 못하면 -1 출력
*/
class Ex1194 {

    static int n, m;
    static char[][] maze;
    static int[][][] distance;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static final int DOOR = 1;
    static final int KEY = 2;
    static final int EXIT = 3;
    static final int WALL = 4;
    static final int NONE = 5;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        maze = new char[n][m];
        distance = new int[n][m][1 << 6];
        Queue<Point> q = new LinkedList<>();
        for (int r = 0; r < n; r++) {
            String line = sc.next();
            for (int c = 0; c < m; c++) {
                char temp = line.charAt(c);
                maze[r][c] = temp;
                if (temp == '0') {
                    q.add(new Point(r, c, 0));
                    distance[r][c][0] = 1;
                }

            }
        }
        while (!q.isEmpty()) {
            Point now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
                if (isOutOfRange(nr, nc)) continue;
                int next = maze[nr][nc];
                switch (getType(next)) {
                    case WALL -> {
                        continue;
                    }
                    case NONE -> {
                        if (distance[nr][nc][now.key] == 0) {
                            distance[nr][nc][now.key] = distance[now.r][now.c][now.key] + 1;
                            q.add(new Point(nr, nc, now.key));
                        }
                    }
                    case EXIT -> {
                        System.out.println(distance[now.r][now.c][now.key]);
                        return;
                    }
                    case KEY -> {
                        int nextKey = now.key | (1 << (next - 'a'));
                        if (distance[nr][nc][nextKey] == 0) {
                            distance[nr][nc][nextKey] = distance[now.r][now.c][now.key] + 1;
                            q.add(new Point(nr, nc, nextKey));
                        }
                    }
                    case DOOR -> {
                        if ((now.key & (1 << (next - 'A'))) == 0) continue;
                        if (distance[nr][nc][now.key] == 0) {
                            distance[nr][nc][now.key] = distance[now.r][now.c][now.key] + 1;
                            q.add(new Point(nr, nc, now.key));
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }

    static boolean isOutOfRange(int r, int c) {
        return r < 0 || r >= n || c < 0 || c >= m;
    }

    static int getType(int c) {
        if (c == '#') return WALL;
        else if (c == '.' || c == '0') return NONE;
        else if (c >= 'a' && c <= 'f') return KEY;
        else if (c >= 'A' && c <= 'F') return DOOR;
        else if (c == '1') return EXIT;
        else return -1;
    }

    static class Point {
        int r, c, key;

        Point(int r, int c, int k) {
            this.r = r;
            this.c = c;
            this.key = k;
        }
    }

}
