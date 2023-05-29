package inflearn.lecture02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Ex04_07 {

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 10}, {20, 25}, {5, 15}, {2, 5}})); // 2
        System.out.println(solution(new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}})); // 5
        System.out.println(solution(new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}})); // 3
        System.out.println(solution(new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}})); // 3
    }

    public static int solution(int[][] meetings) {
        // 회의 시작시간 순으로 정렬
        Arrays.sort(meetings, Comparator.comparingInt(x -> x[0]));
        List<int[]> list = new ArrayList<>();

        for (int[] meeting : meetings) {
            int listSize = list.size();
            boolean isChangeMeetingRoom = false;
            for (int i = 0; i < listSize; i++) {
                int[] room = list.get(i);

                // 예정 미팅이 현재 회의실을 사용 중인 미팅보다 이후면 예정 미팅으로 변경
                if (room[1] <= meeting[0]) {
                    list.set(i, meeting);
                    isChangeMeetingRoom = true;
                    break;
                }
            }

            // 예정 미팅으로 변경되지 않았다면, 만족하는 회의실이 없는 것이므로 회의실을 늘림.
            if (!isChangeMeetingRoom) {
                list.add(meeting);
            }
        }

        return list.size();
    }

}
