package inflearn;

import java.util.Scanner;

public class Ex001 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        char ch = in.nextLine().charAt(0);

        System.out.println(solution(str, ch));
        System.out.println(solution2(str, ch));
    }

    public static int solution(String str, char ch) {
        int answer = 0;
        for (int i = 0; i < str.length(); i++) {
            if (String.valueOf(str.charAt(i)).equalsIgnoreCase(String.valueOf(ch))) {
                answer++;
            }
        }

        return answer;
    }

    public static int solution2(String str, char ch) {
        int answer = 0;
        str = str.toUpperCase();
        ch = Character.toUpperCase(ch);
        for (char c : str.toCharArray()) {
            if (c == ch) {
                answer++;
            }
        }

        return answer;
    }

}
