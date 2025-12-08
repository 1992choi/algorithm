package fastcampus.codingpackage.part3.ch01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
    풀이

    - 빙산이 녹으면서 두 덩어리 이상으로 분리되는 최초의 시점을 찾는 문제
    - 모든 빙산 좌표를 iceList에 저장해서, 필요한 부분만 갱신하며 시간 단축
    - 1년마다 다음 순서를 반복함:
        1) 각 빙산 주변의 바닷물(0)의 개수만큼 높이를 감소시킴
        2) 높이가 0 이하가 된 빙산은 리스트에서 제거
        3) 남아 있는 빙산들을 대상으로 DFS를 수행해 “연결된 빙산의 개수”를 계산
    - 전체 빙산 개수와 DFS로 구한 연결 빙산 개수가 다르면 → 빙산이 분리된 상태
    - 분리 시점(년 수)을 출력, 끝까지 분리되지 않으면 0 출력

    유의점
    - 빙산 높이를 바로 earth[][]에 반영하면, 다음 빙산의 계산 시 이미 녹은 높이를 0으로 판단하여
      실제보다 더 많이 녹는 오류가 발생할 수 있음.
    - 따라서 한 해(year) 동안 "모든 빙산의 녹는 양을 먼저 계산"하고,
      그 다음에 "높이를 일괄 갱신"하는 방식으로 처리해야 정확한 시뮬레이션이 가능함.
*/
class Ex2573 {

    static int n, m;
    static int[][] earth;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static List<Ice> iceList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        earth = new int[n][m];
        visited = new boolean[n][m];
        iceList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                earth[i][j] = sc.nextInt();
                if (earth[i][j] > 0) {
                    iceList.add(new Ice(i, j, earth[i][j]));  // 초기 빙산 목록 저장
                }
                visited[i][j] = true; // DFS 시 탐색 대상만 false 로 만들기 위함
            }
        }

        for (int year = 1; !iceList.isEmpty(); year++) {
            // 1) 주변 바닷물 개수만큼 빙산 높이 감소
            for (int i = 0; i < iceList.size(); i++) {
                Ice ice = iceList.get(i);
                for (int j = 0; j < 4; j++) {
                    int nr = ice.row + dr[j];
                    int nc = ice.col + dc[j];
                    if (earth[nr][nc] == 0) ice.height--;
                }
            }

            // 2) 감소된 높이를 기준으로 실제 지도 반영 및 제거 처리
            for (int i = 0; i < iceList.size(); i++) {
                Ice ice = iceList.get(i);
                if (ice.height <= 0) {
                    earth[ice.row][ice.col] = 0;
                    iceList.set(i, iceList.get(iceList.size() - 1)); // 리스트에서 제거
                    iceList.remove(iceList.size() - 1);
                    i--;
                } else {
                    visited[ice.row][ice.col] = false; // DFS 탐색 대상 초기화
                }
            }

            // 3) 빙산 덩어리 개수 확인 (연결 요소가 2개 이상이면 분리된 것)
            if (iceList.size() > 0 && dfs(iceList.get(0).row, iceList.get(0).col) != iceList.size()) {
                System.out.println(year);
                System.exit(0);
            }
        }

        System.out.println(0); // 끝까지 분리되지 않은 경우
    }

    static int dfs(int r, int c) {
        visited[r][c] = true;
        int cnt = 1;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (visited[nr][nc]) continue; // 바다거나 방문한 곳은 제외
            cnt += dfs(nr, nc); // 연결된 빙산 개수 합산
        }

        return cnt;
    }

    static class Ice {
        int row;
        int col;
        int height;

        public Ice(int r, int c, int h) {
            this.row = r;
            this.col = c;
            this.height = h;
        }
    }

}
