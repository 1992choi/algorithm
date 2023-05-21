package inflearn.lecture02;

import java.util.*;

public class Ex03_05 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[][]{{2, 3}, {1, 2}, {8, 2}, {3, 1}, {10, 2}}))); // [1, 3, 0, 2, 4]
        System.out.println(Arrays.toString(solution(new int[][]{{5, 2}, {7, 3}, {1, 3}, {1, 5}, {2, 2}, {1, 1}}))); // [5, 4, 2, 0, 1, 3]
        System.out.println(Arrays.toString(solution(new int[][]{{1, 2}, {2, 3}, {1, 3}, {3, 3}, {8, 2}, {1, 5}, {2, 2}, {1, 1}}))); // [7, 0, 6, 1, 4, 2, 3, 5]
        System.out.println(Arrays.toString(solution(new int[][]{{999, 1000}, {996, 1000}, {998, 1000}, {999, 7}}))); // [1, 3, 0, 2]
    }

    public static int[] solution(int[][] tasks) {
        int[] answer = new int[tasks.length];
        boolean[] doneFlag = new boolean[tasks.length]; // 완료되었는지 판단
        int seq = 0; // 작업이 된 순서
        int second = 0; // 현재 시간

        while (!isAllDone(doneFlag)) {
            List<Integer[]> processlist = new ArrayList<>(); // 작업 대상이 되는 프로세스
            for (int i = 0; i < tasks.length; i++) {
                int callTime = tasks[i][0]; // 호출시간
                int execTime = tasks[i][1]; // 실행시간

                // 조건 1. 현재시간과 호출시간을 비교하여 호출할 수 있는 것만 판단 기준으로 삼기
                // 조건 2. 완료 안된 것만 판단 기준으로 삼기
                if (second >= callTime && !doneFlag[i]) {
                    processlist.add(new Integer[]{i, callTime, execTime}); // 작업번호 / 호출시간 / 수행시간
                }
            }

            if (processlist.size() > 0) {
                Collections.sort(processlist, new Comparator<Integer[]>() {
                    @Override
                    public int compare(Integer[] o1, Integer[] o2) {
                        if (!o1[2].equals(o2[2])) { // 실행시간이 다르다면 실행시간으로 정렬
                            return o1[2].compareTo(o2[2]);
                        }
                        return o1[0].compareTo(o2[0]); // 그렇지 않다면 작업번호 순으로 정렬
                    }
                });

                Integer[] currentProcess = processlist.get(0); // 작업대상으로 선정된 프로세스
                doneFlag[currentProcess[0]] = true; // 완료처리
                second += currentProcess[2]; // 수행시간 만큼 현재시간 흐르게 하기
                answer[seq] = currentProcess[0];
                seq++;
            } else {
                second++;
            }
        }

        return answer;
    }

    public static boolean isAllDone(boolean[] doneFlag) {
        for (boolean isDone : doneFlag) {
            if (!isDone) {
                return false;
            }
        }

        return true;
    }

}
