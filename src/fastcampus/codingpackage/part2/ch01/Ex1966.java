package fastcampus.codingpackage.part2.ch01;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex1966 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            int printCount = sc.nextInt();
            int targetIndex = sc.nextInt();

            Queue<Print> queue = new LinkedList<>();
            for (int j = 0; j < printCount; j++) {
                queue.offer(new Print(j, sc.nextInt()));
            }

            int processCount = 1;
            while (!queue.isEmpty()) {
                Print currentPrint = queue.poll();
                if (queue.stream().anyMatch(q -> q.priority > currentPrint.priority)) {
                    queue.offer(currentPrint);
                } else {
                    if (currentPrint.idx == targetIndex) {
                        System.out.println(processCount);
                    }
                    processCount++;
                }
            }
        }

    }

    static class Print {
        int idx;
        int priority;

        public Print(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }

        @Override
        public String toString() {
            return "[ idx=" + idx + ", priority=" + priority + " ]";
        }
    }

}

/*
    class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int T = sc.nextInt(); // 테스트 케이스 개수 입력
            while (T-- > 0) {
                int N = sc.nextInt(); // 문서의 개수
                int M = sc.nextInt(); // 찾고자 하는 문서의 인덱스 (0부터 시작)

                Queue<Job> q = new LinkedList<>(); // 문서 큐 생성
                Integer[] prioritySequence = new Integer[N]; // 문서들의 중요도만 저장할 배열

                // 입력받은 문서들을 큐와 배열에 각각 저장
                for (int i = 0; i < N; i++) {
                    prioritySequence[i] = sc.nextInt();
                    q.offer(new Job(i, prioritySequence[i]));
                }

                // 중요도 배열을 내림차순으로 정렬
                // → 이 배열은 "현재 가장 높은 중요도 순서"를 알기 위해 사용됨
                // 즉, 큐 안에서 문서를 순회할 때,
                // prioritySequence[i]는 "이번 차례에 출력되어야 하는 중요도"를 의미
                Arrays.sort(prioritySequence, Collections.reverseOrder());

                // i는 출력된 문서의 순서를 의미
                for (int i = 0; i < N; i++) {
                    // 큐의 맨 앞 문서의 중요도가 현재 출력해야 할 최고 중요도와 다르면,
                    // 뒤로 보내서 순서를 바꾼다.
                    while (q.peek().priority != prioritySequence[i])
                        q.offer(q.poll());

                    // 이제 큐의 맨 앞이 이번에 출력될 문서임
                    // 만약 그 문서가 찾고자 하는 문서(M번째 문서)라면,
                    // 현재 출력 순서(i + 1)를 출력하고 종료
                    if (q.peek().index == M) {
                        System.out.println(i + 1);
                        break;
                    }

                    // 아니라면 그 문서를 출력(큐에서 제거)
                    q.poll();
                }
            }
        }
    }

    class Job {
        int index;
        int priority;
        Job (int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
 */