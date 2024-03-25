package inflearn.lecture01.ex07;

import java.util.*;

/**
 * 문제해법 보고 푼 문제.
 */
public class Ex07_14_02 {

    public static void main(String[] args) {
        // 데이터 셋팅
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] check = new int[n + 1]; // 방문 체크
        int[] answer = new int[n + 1]; // 최소 이동 간선 수

        List<List<Integer>> gragh = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            gragh.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int idx = in.nextInt();
            int value = in.nextInt();
            gragh.get(idx).add(value);
        }

        // 탐색
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll(); // 출발 노드
            for (int nextNode : gragh.get(currentNode)) { // 갈 수 있는 노드
                if (check[nextNode] == 0) { // 아직 방문하지 않았다면 방문을 위해 큐에 추가
                    queue.offer(nextNode);
                    check[nextNode] = 1;
                    answer[nextNode] = answer[currentNode] + 1;
                }
            }
        }

        // 최소 이동 간선 수 출력
        for (int i = 2; i <= n; i++) {
            System.out.println(i + "  :  " + answer[i]);
        }

        /*
            - 입력 값
                6 9
                1 3
                1 4
                2 1
                2 5
                3 4
                4 5
                4 6
                6 2
                6 5
         */
    }

}

