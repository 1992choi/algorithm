package fastcampus.codingpackage.part2.ch02;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/*
    풀이
    - 기타의 6개 줄은 각각 독립적으로 동작하므로, 줄마다 별도의 스택으로 관리한다.
      (pushed[1] ~ pushed[6] 각 스택은 해당 줄에서 현재 누르고 있는 프렛들을 저장한다)

    접근 아이디어:
    1. 입력으로 (줄 번호, 프렛 번호)가 주어질 때,
       현재 줄의 스택 top(가장 마지막으로 누른 프렛)과 비교한다.

    2. 스택 top > 새 프렛 → 더 높은 프렛을 누른 상태이므로 손가락을 뗀다(pop, moveCount++)
       - 낮은 프렛으로 가기 위해 손가락을 여러 번 뗄 수 있다.
       - 새 프렛보다 작거나 같은 프렛이 나올 때까지 pop 반복.

    3. 스택 top == 새 프렛 → 이미 누르고 있는 프렛이므로 아무 동작도 하지 않는다.

    4. 스택이 비었거나 top < 새 프렛 → 새 프렛을 누른다(push, moveCount++)

    5. 모든 음을 처리한 후 누른·뗀 횟수의 총합(moveCount)을 출력한다.

    요약:
    - 각 줄을 스택으로 관리.
    - 높은 프렛은 pop, 새로운 프렛은 push.
    - 프렛을 새로 누르거나 손을 뗄 때마다 moveCount를 증가시킨다.
*/
public class Ex2841 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int P = sc.nextInt();

        Deque<Integer>[] pushed = new ArrayDeque[7];
        for (int i = 1; i <= 6; i++)
            pushed[i] = new ArrayDeque<>();

        int moveCount = 0;
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            int fret = sc.nextInt();

            while (!pushed[num].isEmpty()) {
                if (pushed[num].peekLast() > fret) {
                    pushed[num].pollLast();
                    moveCount++;
                } else break;
            }
            if (!pushed[num].isEmpty() && pushed[num].peekLast() == fret)
                continue;

            pushed[num].offerLast(fret);
            moveCount++;
        }
        System.out.println(moveCount);
    }

}