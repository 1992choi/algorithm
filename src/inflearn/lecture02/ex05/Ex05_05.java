package inflearn.lecture02.ex05;

import java.util.Arrays;

public class Ex05_05 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"a 20", "b 12", "a 10", "c 11", "e 12"}))); // [35, 21, 0, 10, 21]
        System.out.println(Arrays.toString(solution(new String[]{"a 17", "b 12", "a 10", "c 11", "b 24", "a 25", "b 12"}))); // [35, 21, 0, 10, 38, 59, 21]
        System.out.println(Arrays.toString(solution(new String[]{"b 20", "c 15", "a 200", "b 11", "b 24", "a 25", "b 12"}))); // [15, 23, 82, 0, 15, 82, 0]
        System.out.println(Arrays.toString(solution(new String[]{"a 30", "a 25", "a 25", "b 20", "b 25", "a 25", "b 30"}))); // [45, 20, 20, 0, 0, 20, 75]
    }

    public static int[] solution(String[] students) {
        int[] answer = new int[students.length];

        for (int i = 0; i < students.length; i++) {
            String myTeam = students[i].split(" ")[0];
            int myAttack = Integer.parseInt(students[i].split(" ")[1]);
            int myScore = 0;

            for (int j = 0; j < students.length; j++) {
                if (i != j) {
                    String opponentTeam = students[j].split(" ")[0];
                    int opponentAttack = Integer.parseInt(students[j].split(" ")[1]);
                    if (!myTeam.equals(opponentTeam) && myAttack > opponentAttack) {
                        myScore += opponentAttack;
                    }
                }
            }

            answer[i] = myScore;
        }

        return answer;
    }

}
