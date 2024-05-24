package programmers.lv2;

import java.util.HashSet;
import java.util.Set;

// 프로그래머스 Lv2. 방문 길이 - https://school.programmers.co.kr/learn/courses/30/lessons/49994
public class Ex49994 {

    public static void main(String[] args) {
        System.out.println(solution("ULURRDLLU")); // 7
        System.out.println(solution("LULLLLLLU")); // 7
    }

    public static int solution(String dirs) {
        /*
            이동한 좌표 기재.
            '이동한 축_이동하지 않은 축의 현재 좌표_이동한 Y좌표 세트'의 형태로 기입.
            Ex) 최초상태에서 U일 경우, 'Y_0_01'과  'Y_0_10'형태로 기입
         */
        Set<String> set = new HashSet<>();
        int[] currentLocation = {0, 0}; // 현재 위치. x축이 열, y축이 행이므로 currentLocation[0]=y, currentLocation[1]=x

        for (char dir : dirs.toCharArray()) {
            if (dir == 'U') {
                if (currentLocation[0] < 5) {
                    set.add("Y_" + currentLocation[1] + "_" + currentLocation[0] + "" + (currentLocation[0] + 1));
                    set.add("Y_" + currentLocation[1] + "_" + (currentLocation[0] + 1) + "" + currentLocation[0]);

                    currentLocation[0]++;
                }
            } else if (dir == 'D') {
                if (currentLocation[0] > -5) {
                    set.add("Y_" + currentLocation[1] + "_" + currentLocation[0] + "" + (currentLocation[0] - 1));
                    set.add("Y_" + currentLocation[1] + "_" + (currentLocation[0] - 1) + "" + currentLocation[0]);

                    currentLocation[0]--;
                }
            } else if (dir == 'R') {
                if (currentLocation[1] < 5) {
                    set.add("X_" + currentLocation[0] + "_" + currentLocation[1] + "" + (currentLocation[1] + 1));
                    set.add("X_" + currentLocation[0] + "_" + (currentLocation[1] + 1) + "" + currentLocation[1]);

                    currentLocation[1]++;
                }
            } else if (dir == 'L') {
                if (currentLocation[1] > -5) {
                    set.add("X_" + currentLocation[0] + "_" + currentLocation[1] + "" + (currentLocation[1] - 1));
                    set.add("X_" + currentLocation[0] + "_" + (currentLocation[1] - 1) + "" + currentLocation[1]);

                    currentLocation[1]--;
                }
            }
        }

        return set.size() / 2;
    }

}
