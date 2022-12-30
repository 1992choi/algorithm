package cospro.exam01;

public class Solution06 {

    public int func(int record) {
        if (record == 0) return 1;
        else if (record == 1) return 2;
        return 0;
    }

    public int solution(int[] recordA, int[] recordB) {
        int cnt = 0;
        for (int i = 0; i < recordA.length; i++) {
            if (recordA[i] == recordB[i])
                continue;
            else if (recordA[i] == func(recordB[i]))
                cnt = cnt + 3;
            else
                // cnt = cnt - 1; // 해당 부분이 잘못된 부분으로 아래 코드와 같이 수정하면 원하는 결과 값을 리턴할 수 있음.
                cnt = cnt - 1 < 0 ? 0 : cnt - 1;
        }
        return cnt;
    }

    // The following is main method to output testcase. The main method is correct and you shall correct solution method.
    public static void main(String[] args) {
        Solution06 sol = new Solution06();
        int[] recordA = {2, 0, 0, 0, 0, 0, 1, 1, 0, 0};
        int[] recordB = {0, 0, 0, 0, 2, 2, 0, 2, 2, 2};
        int ret = sol.solution(recordA, recordB);

        // Press Run button to receive output.
        System.out.println("Solution: return value of the method is " + ret + " .");
    }

}
