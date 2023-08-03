package inflearn.lecture02.ex05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Ex05_05_Answer {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"a 20", "b 12", "a 10", "c 11", "e 12"}))); // [35, 21, 0, 10, 21]
        System.out.println(Arrays.toString(solution(new String[]{"a 17", "b 12", "a 10", "c 11", "b 24", "a 25", "b 12"}))); // [35, 21, 0, 10, 38, 59, 21]
        System.out.println(Arrays.toString(solution(new String[]{"b 20", "c 15", "a 200", "b 11", "b 24", "a 25", "b 12"}))); // [15, 23, 82, 0, 15, 82, 0]
        System.out.println(Arrays.toString(solution(new String[]{"a 30", "a 25", "a 25", "b 20", "b 25", "a 25", "b 30"}))); // [45, 20, 20, 0, 0, 20, 75]
    }

    public static int[] solution(String[] students) {
        int n = students.length;
        int[] answer = new int[n];
        ArrayList<Info> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Character a = students[i].split(" ")[0].charAt(0);
            int b = Integer.parseInt(students[i].split(" ")[1]);
            list.add(new Info(i, a, b));
        }
        Collections.sort(list);
        HashMap<Character, Integer> Tp = new HashMap<>();
        int j = 0, total = 0;
        for (int i = 1; i < n; i++) {
            for (; j < n; j++) {
                if (list.get(j).power < list.get(i).power) {
                    total += list.get(j).power;
                    char x = list.get(j).team;
                    Tp.put(x, Tp.getOrDefault(x, 0) + list.get(j).power);
                } else break;
            }
            answer[list.get(i).idx] = total - Tp.getOrDefault(list.get(i).team, 0);
        }
        return answer;
    }

    static class Info implements Comparable<Info> {
        public int idx;
        public Character team;
        public int power;

        Info(int idx, Character team, int power) {
            this.idx = idx;
            this.team = team;
            this.power = power;
        }

        @Override
        public int compareTo(Info ob) {
            return this.power - ob.power;
        }
    }

}
