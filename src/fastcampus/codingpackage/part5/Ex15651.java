package fastcampus.codingpackage.part5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
  풀이

  - 핵심 아이디어
    - 길이가 M인 수열을 만들어야 한다
    - 1부터 N까지의 숫자를 사용하며 중복 선택이 가능하다
    - 모든 경우의 수를 탐색하기 위해 DFS(백트래킹)를 사용한다

  - 탐색 방식
    - depth는 현재 수열에서 몇 번째 위치를 채우는지 의미한다
    - depth가 M이 되면 하나의 완성된 수열이므로 출력한다
    - 그렇지 않으면 1 ~ N까지 반복하면서 현재 위치에 값을 넣고 다음 depth로 이동한다

  - 중복 허용 처리
    - 같은 숫자를 여러 번 사용할 수 있으므로 방문 체크 배열이 필요 없다
    - 매 depth마다 항상 1 ~ N을 전부 탐색한다

  - 출력 최적화
    - 경우의 수가 최대 N^M (최대 약 80만 줄) 이므로
      System.out.println을 매번 호출하면 시간초과 발생
    - StringBuilder에 결과를 누적한 후 한 번에 출력한다
*/
class Ex15651 {

    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        arr = new int[M];

        dfs(0);

        System.out.print(sb);
    }

    static void dfs(int depth) {
        // 수열이 완성된 경우
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        // 1 ~ N까지 모든 숫자 선택 (중복 허용)
        for (int i = 1; i <= N; i++) {
            arr[depth] = i;
            dfs(depth + 1);
        }
    }

}