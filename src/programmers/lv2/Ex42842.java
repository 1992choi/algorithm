package programmers.lv2;

import java.util.Arrays;

// 프로그래머스 Lv2. 카펫 - https://school.programmers.co.kr/learn/courses/30/lessons/42842
public class Ex42842 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(10, 2))); // [4,3]
        System.out.println(Arrays.toString(solution(8, 1))); // [3,3]
        System.out.println(Arrays.toString(solution(24, 24))); // [8,6]
        System.out.println(Arrays.toString(solution(18, 6))); // [8,3]
    }

    public static int[] solution(int brown, int yellow) {
        int width = 1;
        int height = 1;
        for (width = 1; width <= brown; width++) {
            for (height = 1; height <= width; height++) { // 가로 길이는 세로 길이와 같거나, 세로 길이보다 길다는 조건
                // 노랑 : (가로-2) * (세로-2)
                // 갈색 : 가로 * 세로 - 노랑
                int yellowCount = (width - 2) * (height - 2);
                int brownCount = width * height - yellowCount;
                if (yellow == yellowCount && brown == brownCount) {
                    return new int[]{width, height};
                }
            }
        }

        return new int[]{width, height};
    }

}
