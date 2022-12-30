package cospro.exam05;

public class Solution06 {

    public String solution(String s1, String s2, int p, int q) {
        String answer = "";
        int s1Val = 0;
        int s2Val = 0;
        int sumVal = 0;
        int tmpP = 1;

        // p진법 합계
        for (int i = s1.length() - 1; i >= 0; i--) {
            s1Val += Character.getNumericValue(s1.charAt(i)) * tmpP;
            tmpP *= p;
        }
        tmpP = 1;
        for (int i = s2.length() - 1; i >= 0; i--) {
            s2Val += Character.getNumericValue(s2.charAt(i)) * tmpP;
            tmpP *= p;
        }
        sumVal = s1Val + s2Val;

        // q진법으로 변환
        while (sumVal != 0) {
            answer += String.valueOf(sumVal % q);
            sumVal /= q;
        }

        return new StringBuffer(answer).reverse().toString();
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Solution06 sol = new Solution06();
        String s1 = new String("112001");
        String s2 = new String("12010");
        int p = 3;
        int q = 8;
        String ret = sol.solution(s1, s2, p, q);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }

}
