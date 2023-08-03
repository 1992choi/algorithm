package inflearn.lecture02.ex04;

public class Ex04_06 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3}, 5)); // 3
        System.out.println(solution(new int[]{8, 5, 2, 9, 10, 7}, 30)); // 6
        System.out.println(solution(new int[]{8, 9, 12, 23, 45, 16, 25, 50}, 100)); // 5
    }

    public static int solution(int[] tasks, long k) {
        int answer = -1;

        // 정전이 나기 전까지 수행
        int seconds = 0;
        int lastIndex = 0; // 마지막으로 처리한 태스크의 인덱스
        while (seconds < k) {
            if (tasks[lastIndex] == 0) {
                lastIndex = (lastIndex + 1) % tasks.length;
            } else {
                // System.out.print(seconds + " ~ " + (seconds + 1) + " : ");

                tasks[lastIndex]--;
                seconds++;
                lastIndex = (lastIndex + 1) % tasks.length;

                // System.out.print(Arrays.toString(tasks));
                // System.out.println();
            }
        }

        // 정전이후 수행 : 마지막 수행한 인덱스의 다음 인덱스부터 순회하며 작업이 남이 있는지 파악
        // Ex) 마지막 작업이 3번째 였으면, 4, 5, 6, ... 2번째로 탐색

        // System.out.println("새로 시작할 작업 인덱스 = " + lastIndex);
        // System.out.println(Arrays.toString(tasks));
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[(lastIndex + i) % tasks.length] != 0) {
                answer = (lastIndex + i) % tasks.length;
                break;
            }
        }

        return answer + 1;
    }

}