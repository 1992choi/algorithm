package inflearn.lecture02;

import java.util.*;

public class Ex08_02 {

    public static void main(String[] args) {
        // TODO: 2023/06/26. 오답. 해법영상처럼 큐에 데이터는 담기나 담기는 레벨이 다름. Ex) 레벨2에서 2,7,8,13이 담겨야하나 레벨1때 담김
        System.out.println(solution(new int[][]{{1, 2, 3, 4, 5, 6, 19}, {2, 7, 8, 13}, {5, 9, 10}, {9, 11, 12, 18}, {13, 14, 15}, {14, 12, 16, 17}}, 1, 12)); // 2
        //System.out.println(solution(new int[][]{{1, 3, 5, 7}, {9, 3, 12}, {6, 5, 8}, {2, 8, 14, 15}, {2, 14, 16}}, 1, 14)); // 2
        //System.out.println(solution(new int[][]{{7, 12}, {5, 19}, {7, 19}, {9, 12, 13}, {9, 5, 15}}, 9, 19)); // 1
        //System.out.println(solution(new int[][]{{1, 2, 3, 4, 5}, {9, 7, 10}, {7, 6, 3, 8}, {5, 11, 8, 12}}, 1, 10)); //2
    }

    public static int solution(int[][] routes, int s, int e) {
        int answer = 0;

        // 인접리스트 생성 (= 호선과 역정보를 셋에 담는다. [key=역번호 / value=호선])
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                if (graph.containsKey(routes[i][j])) { // 이미 역정보가 있는 경우는 호선 추가
                    graph.get(routes[i][j]).add(i);
                } else { // 역정보가 없는 경우는 역정보와 호선 추가
                    Set<Integer> set = new HashSet<>();
                    set.add(i);
                    graph.put(routes[i][j], set);
                }
            }
        }

        // 레벨 탐색
        boolean[] visited = new boolean[routes.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);

        while (!queue.isEmpty()) {
            System.out.println("=========================== level=" + answer);
            System.out.println("=========================== visited=" + Arrays.toString(visited));
            // 역정보를 꺼낸 후 역이 소속되어 있는 호선을 모두 찾는다.
            int key = queue.poll();
            Set<Integer> tmpSet = graph.get(key);
            System.out.println("key=" + key + ", tmpSet=" + tmpSet);

            // 호선에 속한 역정보를 찾는다.
            Iterator<Integer> it = tmpSet.iterator();
            while (it.hasNext()) {
                int line = it.next(); // 호선
                System.out.println(line + " 호선 탐색");
                if (visited[line]) {
                    System.out.println(line + " 호선은 이미 탐색했으므로 스킵");
                    continue;
                }
                for (int i = 0; i < routes[line].length; i++) { // 호선에 속한 역정보 큐에 담기
                    if (routes[line][i] == e) {
                        return answer;
                    }

                    queue.add(routes[line][i]);
                }

                // 탐색한 호선 체크
                visited[line] = true;
                answer++;
            }
            System.out.println("queue=" + queue);
            System.out.println();
        }

        return answer;
    }

}