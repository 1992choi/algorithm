package cospro.exam01;

public class Solution03 {

    public int solution(String pos) {
        int answer = 0;
        int x = pos.charAt(0) - 64; // A=1, B=2, C=3... 으로 변환시키기 위함
        int y = Integer.parseInt(Character.toString(pos.charAt(1)));

        if (x + 1 <= 8 && y + 2 <= 8) {
            answer++;
        }
        if (x + 2 <= 8 && y + 1 <= 8) {
            answer++;
        }
        if (x + 2 <= 8 && y - 1 >= 1) {
            answer++;
        }
        if (x + 1 <= 8 && y - 2 >= 1) {
            answer++;
        }
        if (x - 1 >= 1 && y - 2 >= 1) {
            answer++;
        }
        if (x - 2 >= 1 && y - 1 >= 1) {
            answer++;
        }
        if (x - 2 >= 1 && y + 1 <= 8) {
            answer++;
        }
        if (x - 1 >= 1 && y + 2 <= 8) {
            answer++;
        }
        // 규칙 찾아서 코드 줄여볼 것...

        return answer;
    }

    public static void main(String[] args) {
        Solution03 sol = new Solution03();
        System.out.println(sol.solution("A7"));
        System.out.println(sol.solution("D4"));
        System.out.println(sol.solution("F2"));
        System.out.println(sol.solution("H1"));
    }

}
