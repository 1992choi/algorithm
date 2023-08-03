package inflearn.lecture02.ex04;

import java.util.Arrays;

public class Ex04_01 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{5, 6, 7, 8, 9}))); // [8, 5, 6, 9, 7]
        System.out.println(Arrays.toString(solution(new int[]{5, 4, 3, 2, 1}))); // [1, 2, 4, 3, 5]
        System.out.println(Arrays.toString(solution(new int[]{12, 5, 7, 23, 45, 21, 17}))); // [5, 12, 17, 7, 21, 23, 45]
    }

    public static int[] solution(int[] nums) {
        return Arrays.stream(nums).boxed().sorted((o1, o2) -> {
            // 이진수로 변경 후 0을 모두 공백으로 치환하여 1의 갯수 얻은 후 비교
            int o1Binary1Cnt = Integer.toBinaryString(o1).replaceAll("0", "").length();
            int o2Binary1Cnt = Integer.toBinaryString(o2).replaceAll("0", "").length();

            if (o1Binary1Cnt != o2Binary1Cnt) {
                return o1Binary1Cnt < o2Binary1Cnt ? -1 : 1;
            } else {
                return o1.compareTo(o2);
            }
        }).mapToInt(Integer::intValue).toArray();
    }

}
