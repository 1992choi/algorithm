package programmers.lv1;

// 프로그래머스 Lv1. 카드 뭉치 - https://school.programmers.co.kr/learn/courses/30/lessons/159994
public class Ex159994 {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"i", "drink", "water"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"})); // "Yes"
        System.out.println(solution(new String[]{"i", "water", "drink"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"})); // "No"
    }

    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        int card1idx = 0;
        int card2idx = 0;

        for (int i = 0; i < goal.length; i++) {
            if (cards1.length > card1idx && goal[i].equals(cards1[card1idx])) {
                card1idx++;
            } else if (cards2.length > card2idx && goal[i].equals(cards2[card2idx])) {
                card2idx++;
            }
        }

        return card1idx + card2idx == goal.length ? "Yes" : "No";
    }

}
