package programmers.codingtest;

import java.util.HashSet;
import java.util.Set;

// 방문 길이 - https://school.programmers.co.kr/learn/courses/30/lessons/49994
public class Ex007 {

    public static void main(String[] args) {
        System.out.println(solution("ULURRDLLU"));
        System.out.println(solution("LULLLLLLU"));
    }

    public static int solution(String dirs) {
        Set<String> set = new HashSet<>();
        int x = 0;
        int y = 0;

        for (char c : dirs.toCharArray()) {
            if (c == 'U') {
                if (y < 5) {
                    y++;
                    set.add(x + "_" + (y - 1) + "_" + x + "_" + y);
                    set.add(x + "_" + y + "_" + x + "_" + (y - 1));
                }
            } else if (c == 'D') {
                if (y > -5) {
                    y--;
                    set.add(x + "_" + (y + 1) + "_" + x + "_" + y);
                    set.add(x + "_" + y + "_" + x + "_" + (y + 1));
                }
            } else if (c == 'L') {
                if (x > -5) {
                    x--;
                    set.add((x + 1) + "_" + y + "_" + x + "_" + y);
                    set.add(x + "_" + y + "_" + (x + 1) + "_" + y);
                }
            } else if (c == 'R') {
                if (x < 5) {
                    x++;
                    set.add((x - 1) + "_" + y + "_" + x + "_" + y);
                    set.add(x + "_" + y + "_" + (x - 1) + "_" + y);
                }
            }

        }

        return set.size() / 2;
    }

}