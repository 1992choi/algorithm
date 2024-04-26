package inflearn.lecture01.ex08;

import java.util.*;

/**
 * 문제해법 보고 푼 문제.
 */
public class Ex08_15_02 {

    static int n; // 도시 크기
    static int m; // 피자집 개수
    static int[][] arr; // 지도
    static List<Integer[]> house = new ArrayList<>(); // 집 위치
    static List<Integer[]> pizza = new ArrayList<>(); // 피자집 위치
    static Set<Integer> selectedPizza = new HashSet<>();
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        // 입력값 셋팅
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
                if (arr[i][j] == 1) {
                    house.add(new Integer[]{j, i});
                } else if (arr[i][j] == 2) {
                    pizza.add(new Integer[]{j, i});
                }
            }
        }

        // 탐색 및 결과 출력
        dfs(0);
        System.out.println(answer);
    }

    public static void dfs(int startNum) {
        if (selectedPizza.size() == m) {
            int sum = 0;
            for (int i = 0; i < house.size(); i++) {
                int pizzaDist = Integer.MAX_VALUE; // 피자거리
                for (int j = 0; j < pizza.size(); j++) {
                    // 집과 선택된 피자집과의 거리 비교
                    if (selectedPizza.contains(j)) {
                        pizzaDist = Math.min(pizzaDist, Math.abs(pizza.get(j)[0] - house.get(i)[0]) + Math.abs((pizza.get(j)[1] - house.get(i)[1])));
                    }
                }
                sum += pizzaDist;
            }
            answer = Math.min(answer, sum);
        } else {
            for (int i = startNum; i < pizza.size(); i++) {
                selectedPizza.add(i);
                dfs(i + 1);
                selectedPizza.remove(i);
            }
        }
    }

}