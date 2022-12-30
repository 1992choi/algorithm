package cospro.exam01;

public class Solution07 {

    int solution(int[] prices) {
        int INF = 1000000001;
        int tmp = INF;
        int answer = -INF;
        for (int price : prices) {
            if (tmp != INF)
                // answer = Math.max(answer, tmp - price); // 해당 부분이 잘못된 부분으로 아래 코드와 같이 수정하면 원하는 결과 값을 리턴할 수 있음.
                answer = Math.max(answer, price - tmp);
            tmp = Math.min(tmp, price);
        }
        return answer;
    }

    // The following is main method to output testcase. The main method is correct and you shall correct solution method.
    public static void main(String[] args) {
        Solution07 sol = new Solution07();
        int[] prices1 = {1, 2, 3};
        int ret1 = sol.solution(prices1);

        // Press Run button to receive output.
        System.out.println("Solution: return value of the method is " + ret1 + " .");

        int[] prices2 = {3, 1};
        int ret2 = sol.solution(prices2);

        // Press Run button to receive output.
        System.out.println("Solution: return value of the method is " + ret2 + " .");
    }

}
