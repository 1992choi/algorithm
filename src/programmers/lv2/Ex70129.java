package programmers.lv2;

import java.util.Arrays;

// 프로그래머스 Lv2. 이진 변환 반복하기 - https://school.programmers.co.kr/learn/courses/30/lessons/70129
public class Ex70129 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("110010101001"))); // [3,8]
        System.out.println(Arrays.toString(solution("01110"))); // [3,3]
        System.out.println(Arrays.toString(solution("1111111"))); // [4,1]
    }

    public static int[] solution(String s) {
        int changeCnt = 0; // 2진변환 횟수
        int removeZeroCnt = 0; // 0 제거 횟수

        while(!"1".equals(s)) {
            int removeCnt = s.replaceAll("0", "").length(); // s문자열에서 0을 제외한 문자열의 길이
            removeZeroCnt += s.length() - removeCnt;
            s = Integer.toBinaryString(removeCnt);
            changeCnt++;
        }

        return new int[]{changeCnt, removeZeroCnt};
    }

}

