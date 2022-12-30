package cospro.exam06;

public class Solution02 {

    public int solution(int K, String[] words) {
        int answer = 1;
        int sumLength = 0;

        for (int i = 0; i < words.length; i++) {
            if (sumLength + words[i].length() > K) {
                sumLength = 0;
                sumLength += words[i].length() + 1;
                answer++;
            } else {
                sumLength += words[i].length() + 1;
            }
        }

        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Solution02 sol = new Solution02();
        int K = 10;
        String[] words = {new String("nice"), new String("happy"), new String("hello"), new String("world"), new String("hi")};
        int ret = sol.solution(K, words);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소의 반환 값은 " + ret + " 입니다.");
    }

}
