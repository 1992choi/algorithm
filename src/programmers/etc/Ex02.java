package programmers.etc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

// 코딩 테스트 합격자 되기 : 05-4
public class Ex02 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{4, 2, 2, 1, 3, 4}))); // [4, 3, 2, 1]
        System.out.println(Arrays.toString(solution(new int[]{2, 1, 1, 3, 2, 5, 4}))); // [5, 4, 3, 2, 1]
    }

    public static int[] solution(int[] nums) {
        return Arrays.stream(nums)
                .distinct()
                .boxed()
                .collect(Collectors.toList())
                .stream()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
    }

}
