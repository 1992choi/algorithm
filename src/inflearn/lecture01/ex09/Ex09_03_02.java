package inflearn.lecture01.ex09;

import java.util.*;

public class Ex09_03_02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Integer[]{in.nextInt(), in.nextInt()});
        }

        System.out.println(solution(list, n));
    }

    public static int solution(List<Integer[]> list, int n) {
        Map<Integer, Integer> time = new HashMap<>(); // key=시간, value=해당 시간에 참석자 수

        // 시간마다 인원수 체크
        for (Integer[] integers : list) {
            for (int i = integers[0]; i < integers[1]; i++) {
                time.put(i, time.getOrDefault(i, 0) + 1);
            }
        }

        // 최대인원 구하기
        return time.values().stream().max(Integer::compareTo).get();
    }

}
