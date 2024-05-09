package inflearn.lecture01.ex09;

import java.util.*;

public class Ex09_01_02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Integer[]{in.nextInt(), in.nextInt()});
        }

        // System.out.println(solution(list, n));
        System.out.println(solution2(list, n));
    }

    // 그리디 미적용 (채점 통과)
    public static int solution(List<Integer[]> list, int n) {
        int answer = 0;

        for (int i = 0; i < n; i++) {
            boolean check = true;
            for (int j = 0; j < n; j++) {
                // i 보다 키와 몸무게가 모두 큰 사람이 있는지
                if (list.get(i)[0] < list.get(j)[0] && list.get(i)[1] < list.get(j)[1]) {
                    check = false;
                }
            }

            if (check) {
                answer++;
            }
        }

        return answer;
    }

    // 그리디 적용 - 문제해법 보고 푼 문제.
    public static int solution2(List<Integer[]> list, int n) {
        int answer = 0;

        // 키가 큰 수로 정렬
        Collections.sort(list, (x, y) -> y[0] - x[0]);
//        for (Integer[] integers : list) {
//            System.out.println(Arrays.toString(integers));
//        }

        // 키가 큰 순서로 정렬을 했으니, 몸무게만 비교를 했을 때 내가 앞사람 보다 몸무게가 많다면 선발될 수 있다.
        int maxWeight = list.get(0)[1]; // 조건에 따라서 제일 키가 큰 사람은 무조건 선발될 수 밖에 없음.
        answer++;

        for (int i = 1; i < n; i++) {
            if (maxWeight < list.get(i)[1]) {
                maxWeight = list.get(i)[1];
                answer++;
            }
        }

        return answer;
    }

}
