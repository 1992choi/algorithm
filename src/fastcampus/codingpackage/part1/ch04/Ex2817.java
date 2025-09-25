package fastcampus.codingpackage.part1.ch04;

import java.util.Scanner;

public class Ex2817 {

    static class Score {
        int staffIndex;
        double scr;

        Score(int staffIndex, double scr) {
            this.staffIndex = staffIndex;
            this.scr = scr;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int N = sc.nextInt();

        // 1. 전체 득표수의 5% 미만의 스태프를 후보에서 제외한다.
        double validCut = X * 0.05;
        boolean[] validCandidate = new boolean[26]; // N명의 스태프를 관리하기 위하여 N개 만큼 배열을 만들지 않고, 보다 쉬운 핸들링을 위하여 알파벳만큼 배열 생성 (스태프 이름은 영어이므로 대문자 개수만큼 생성)
        int[] staffVote = new int[26];
        int candidateCount = 0;
        for (int i = 0; i < N; i++) {
            String name = sc.next();
            int vote = sc.nextInt();
            if (vote >= validCut) {
                // 기준 득표수보다 많은 경우, 유효한 스태프임을 체크하고 표를 카운팅
                int index = name.charAt(0) - 'A';
                validCandidate[index] = true;
                staffVote[index] = vote;
                candidateCount++;
            }
        }

        // 2. 남은 스태프마다 받은 득표수를 1~14로 나눈 점수 집합을 구한다.
        Score[] scores = new Score[candidateCount * 14];
        int scoreIndex = 0;
        for (int i = 0; i < 26; i++) {
            if (validCandidate[i]) {
                for (int j = 1; j <= 14; j++)
                    scores[scoreIndex++] = new Score(i, (double) staffVote[i] / j);
            }
        }

        // 3. 전체 점수 집합에서 점수가 큰 1~14번째 스태프에게 칩을 1개씩 지급한다.
        sortScoresDescendingOrder(scores);

        int[] ans = new int[26];
        for (int i = 0; i < 14; i++)
            ans[scores[i].staffIndex]++;

        // 4. 스태프 이름에 대해 사전순으로 후보 스태프와 받은 칩의 수를 출력한다.
        for (int i = 0; i < 26; i++) {
            if (validCandidate[i])
                System.out.println((char) (i + 'A') + " " + ans[i]);
        }
    }

    public static void sortScoresDescendingOrder(Score[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i].scr > arr[j].scr) {
                    Score cur = arr[i];
                    for (int k = i; k > j; k--)
                        arr[k] = arr[k - 1];
                    arr[j] = cur;
                }
            }
        }
    }

}