package cospro.exam04;

public class Solution09 {

    public String solution(int hour, int minute) {
        double hourDegree = hour * (360 / 12);
        double minDegree = minute * (360 / 60);
        double minusVal = hourDegree > minDegree ? hourDegree - minDegree : minDegree - hourDegree;

        String answer = String.valueOf(minusVal);
        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Solution09 sol = new Solution09();
        int hour = 3;
        int minute = 0;
        String ret = sol.solution(hour, minute);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }

}
