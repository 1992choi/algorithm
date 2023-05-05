package doit;

public class Ex001 {

    public static void main(String[] args) {
        System.out.println(solution(1, "1")); // 1
        System.out.println(solution(5, "54321")); // 15
        System.out.println(solution(25, "7000000000000000000000000")); // 7
        System.out.println(solution(11, "10987654321")); // 46
    }

    public static int solution(int count, String str) {
        int answer = 0;

        for (int i = 0; i < count; i++) {
            answer += str.charAt(i) - 48;
        }

        return answer;
    }

}
