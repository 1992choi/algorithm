package fastcampus.codingpackage.part3.ch01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
    풀이

    - 5x5 격자(25명)에서 7명을 선택하는 모든 조합을 탐색하여, 조건에 맞는 경우의 수를 세는 문제.
    - 조건 1: 선택된 7명 중 '이다솜파(S)'가 최소 4명 이상이어야 한다.
    - 조건 2: 선택된 7명의 위치가 서로 인접해(상·하·좌·우) 하나의 연결된 그룹이어야 한다.
    - 25명 중 7명을 고르는 모든 조합(2^25)을 백트래킹으로 생성하며, 7명을 고를 때마다 조건 검증을 진행한다.
    - 인접 여부는 학생 번호를 0~24의 1차원 인덱스로 두고, 격자 형태의 위치 차이(±1, ±5)로 판별한다.
    - 선택된 7명이 인접해 있는지는 DFS로 연결된 학생 수가 7인지로 확인한다.
*/
class Ex1941 {

    public static int[] students = new int[25];  // S=1, Y=0로 저장
    public static boolean[] check = new boolean[25];  // 인접 DFS용 방문 체크

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = 0;

        // 5x5 학생 정보 입력 → 1차원 배열로 저장
        for (int i = 0; i < 5; i++) {
            String str = sc.next();
            for (int j = 0; j < 5; j++) {
                students[cnt] = (str.charAt(j) == 'S') ? 1 : 0;
                cnt++;
            }
        }

        // 가능한 모든 조합 생성 및 조건 만족 개수 출력
        int princess = nextCombination(0);
        System.out.println(princess);
    }

    // 두 학생이 상하좌우로 인접한지 확인
    public static boolean isFriend(int a, int b) {
        int diff = Math.abs(a - b);
        int max = Math.max(a, b);

        // 좌우 인접 → 번호 차이가 1이면서 오른쪽 끝으로 넘어가지 않아야 함  (나머지가 0인 경우는 오른쪽 끝을 넘어가서 다음행에 있는 경우이기 때문에 인접으로 보면 안된다.)
        if (diff == 1 && max % 5 != 0) return true;

        // 상하 인접 → 번호 차이가 5
        if (diff == 5) return true;

        return false;
    }

    static List<Integer> pick = new ArrayList<>(); // 선택된 학생 목록

    // 25명 중 7명을 뽑는 모든 조합 생성 (백트래킹)
    public static int nextCombination(int studentNum) {

        // 7명을 다 뽑은 경우 검증 단계
        if (pick.size() == 7) {

            int cnt = 0;
            // S(Y가 아닌) 학생 수 확인
            for (int i = 0; i < 7; i++) {
                if (students[pick.get(i)] == 1) cnt++;
            }
            // S가 4명 이상이어야 조건 충족
            if (cnt < 4) return 0;

            // 인접 DFS 방문 초기화
            for (int i = 0; i < 7; i++) {
                check[i] = false;
            }

            // 7명이 모두 인접해 있는 경우만 카운트
            if (dfs(0) == 7) return 1;
            return 0;
        }

        // 더 이상 선택할 학생이 없는데 7명이 안 되었으면 종료
        if (studentNum >= 25) return 0;

        int ret = 0;

        // studentNum 학생을 선택하지 않는 경우
        ret += nextCombination(studentNum + 1);

        // studentNum 학생을 선택하는 경우
        pick.add(studentNum);
        ret += nextCombination(studentNum + 1);
        pick.remove(pick.size() - 1);

        return ret;
    }

    // 선택된 7명이 모두 연결되어 있는지 DFS로 확인
    public static int dfs(int studentNum) {
        int count = 1;
        check[studentNum] = true;

        int me = pick.get(studentNum);

        for (int i = 1; i < 7; i++) {
            int you = pick.get(i);

            // 아직 방문하지 않았고, 인접한 경우
            if (!check[i] && isFriend(me, you)) {
                count += dfs(i);
            }
        }
        return count;
    }
}
