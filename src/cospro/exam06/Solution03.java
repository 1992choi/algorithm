package cospro.exam06;

public class Solution03 {

    static int minSub = 9999;

    void comb(int[] arr, boolean[] visited, int start, int r) {
        if (r == 0) {
            int min = 9999;
            int max = 0;
            for (int i = 0; i < arr.length; i++) {
                if (visited[i] == true) {
                    if (max < arr[i]) {
                        max = arr[i];
                    }
                    if (min > arr[i]) {
                        min = arr[i];
                    }
                }
            }

            if (max - min < minSub) {
                minSub = max - min;
            }

            return;
        } else {
            for (int i = start; i < arr.length; i++) {
                visited[i] = true;
                comb(arr, visited, i + 1, r - 1);
                visited[i] = false;
            }
        }
    }

    public int solution(int[] arr, int K) {
        int answer = 0;
        boolean[] visited = new boolean[arr.length];

        comb(arr, visited, 0, K);
        answer = minSub;

        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Solution03 sol = new Solution03();
        int[] arr = {9, 11, 9, 6, 4, 19};
        int K = 4;
        int ret = sol.solution(arr, K);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + "입니다.");
    }

}
