package inflearn.lecture02;

import java.util.Stack;

public class Ex03_02_Answer {

    public static void main(String[] args) {
        System.out.println(solution("3(a2(b))ef")); // "abbabbabbef"
        System.out.println(solution("2(ab)k3(bc)")); // "ababkbcbcbc"
        System.out.println(solution("2(ab3((cd)))")); // "abcdcdcdabcdcdcd"
        System.out.println(solution("2(2(ab)3(2(ac)))")); // "ababacacacacacacab abacacacacacac"
        System.out.println(solution("3(ab2(sg))")); // "absgsgabsgsgabsgsg"
    }

    public static String solution(String s) {
        String answer = "";
        Stack<String> st = new Stack<>();
        for (Character x : s.toCharArray()) {
            if (x == ')') {
                String tmp = "";
                while (!st.empty()) {
                    String c = st.pop();
                    if (c.equals("(")) {
                        String num = "";
                        while (!st.empty() && Character.isDigit(st.peek().charAt(0))) {
                            num = st.pop() + num;
                        }
                        String res = "";
                        int cnt = 0;
                        if (num.equals("")) cnt = 1;
                        else cnt = Integer.parseInt(num);
                        for (int i = 0; i < cnt; i++) res += tmp;
                        st.push(res);
                        break;
                    }
                    tmp = c + tmp;
                }
            } else st.push(String.valueOf(x));
        }
        for (String x : st) answer += x;
        return answer;
    }

}
