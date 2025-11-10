package fastcampus.codingpackage.part2.ch02;

import java.util.Scanner;
import java.util.Stack;

public class Ex4949 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            if (".".equals(str)) break;

            Stack<Character> stack = new Stack<>();
            boolean isValid = true;

            for (char c : str.toCharArray()) {
                if (c == '(' || c == '[') {
                    stack.push(c);
                } else if (c == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        isValid = false;
                        break;
                    }
                } else if (c == ']') {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        isValid = false;
                        break;
                    }
                }
            }

            if (!isValid || !stack.isEmpty()) {
                System.out.println("no");
            } else {
                System.out.println("yes");
            }
        }
    }
}

/*
    풀이

    static boolean isMatch(char open, char close) {
        if (open == '(' && close == ')')
            return true;
        if (open == '[' && close == ']')
            return true;
        return false;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            char[] line = sc.nextLine().toCharArray();
            if (line.length == 1 && line[0] == '.')
                break;

            char[] opened = new char[line.length];
            int topIndex = -1;
            boolean isValid = true;
            for (char ch : line) {
                if (ch == '(' || ch == '[') {
                    opened[++topIndex] = ch;
                }
                else if (ch == ')' || ch == ']') {
                    if (topIndex < 0 || !isMatch(opened[topIndex--], ch)) {
                        isValid = false;
                        break;
                    }
                }
            }
            if (topIndex >= 0) isValid = false;
            System.out.println(isValid ? "yes" : "no");
        }
    }
 */