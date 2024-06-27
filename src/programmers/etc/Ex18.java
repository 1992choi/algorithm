package programmers.etc;

import java.util.HashSet;
import java.util.Set;

// 코딩 테스트 합격자 되기 : 08-4
// 문제해법 보고 푼 문제.
public class Ex18 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4, 8}, 6)); // true
        System.out.println(solution(new int[]{2, 3, 5, 9}, 10)); // false
    }

    public static boolean solution(int[] arr, int target) {
        boolean answer = false;

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            // target에서 자기 자신을 뺏을 때의 값을 원소로 가지고 있는지 확인.
            // 단, 자기 자신일 경우는 제외
            if (set.contains(target - arr[i]) && target - arr[i] != arr[i]) {
                return true;
            }
        }

        return answer;
    }

}
