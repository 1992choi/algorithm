package cospro.exam04;

import java.util.ArrayList;
import java.util.List;

public class Solution10 {

    public int solution(int a, int b) {
        int answer = 0;

        // 소수 판별
        List<Integer> primeNum = new ArrayList<>();
        for (int i = 2; i < b; i++) {
            boolean isPrimeNum = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrimeNum = false;
                    break;
                }
            }

            if (isPrimeNum) {
                primeNum.add(i);
            }
        }

        // 제곱수 or 세제곱수 판별
        for (int i = 0; i < primeNum.size(); i++) {
            int num = primeNum.get(i);
            if (primeNum.get(i) * primeNum.get(i) >= a
                    && primeNum.get(i) * primeNum.get(i) <= b) {
                answer++;
            }

            if (primeNum.get(i) * primeNum.get(i) * primeNum.get(i) >= a
                    && primeNum.get(i) * primeNum.get(i) * primeNum.get(i) <= b) {
                answer++;
            }
        }

        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Solution10 sol = new Solution10();
        int a = 6;
        int b = 30;
        int ret = sol.solution(a, b);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }

}
