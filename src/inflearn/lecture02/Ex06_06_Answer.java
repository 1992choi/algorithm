package inflearn.lecture02;

public class Ex06_06_Answer {

    public static void main(String[] args) {
        System.out.println(solution("25114")); // 6
        System.out.println(solution("23251232")); // 12
        System.out.println(solution("21020132")); // 2
        System.out.println(solution("21350")); // 0
        System.out.println(solution("120225")); // 3
        System.out.println(solution("232012521")); // 12
    }

    static int[] dy;

    public static int solution(String s) {
        dy = new int[101];
        int answer = DFS(0, s);
        return answer;
    }

    public static int DFS(int start, String s) {
        if (dy[start] > 0) return dy[start];
        if (start < s.length() && s.charAt(start) == '0') return 0;
        if (start == s.length() - 1 || start == s.length()) return 1;
        else {
            int res = DFS(start + 1, s);
            int tmp = Integer.parseInt(s.substring(start, start + 2));
            if (tmp <= 26) res += DFS(start + 2, s);
            return dy[start] = res;
        }
    }

}