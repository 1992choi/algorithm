package fastcampus.codingpackage.part2.ch02;

import java.util.Scanner;


/*
    풀이
    - 1부터 N까지의 자연수를 스택에 오름차순으로 push하면서,
      입력으로 주어진 수열을 스택을 통해 만들 수 있는지 판단한다.

    접근 아이디어:
    1. 스택에 1부터 차례로 push하면서, 현재 목표 숫자 x에 도달할 때까지 push 연산을 수행한다.
       - push할 때마다 '+'를 기록한다.

    2. 스택의 top이 x와 같으면 pop한다.
       - pop할 때마다 '-'를 기록한다.

    3. 스택의 top이 x와 다르다면, 해당 수열은 만들 수 없다.
       - "NO"를 출력하고 종료한다.

    4. 모든 입력 숫자에 대해 위 과정을 반복한다.

    핵심 포인트:
    - 'nextNumber'는 스택에 push할 다음 숫자를 의미한다.
    - 입력된 수열의 각 원소를 스택 연산으로 만들 수 있는지 시뮬레이션한다.
    - 모든 연산을 문자열로 기록해 한 번에 출력한다.
*/
public class Ex1874 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        int[] stack = new int[N];  // 스택을 배열로 구현
        int topIndex = -1;         // 스택의 현재 top 위치
        int nextNumber = 1;        // 다음에 push할 숫자
        StringBuilder sb = new StringBuilder();

        for (int x : arr) {
            // 1. 현재 숫자 x에 도달할 때까지 push
            while (nextNumber <= x) {
                sb.append("+\n");
                stack[++topIndex] = nextNumber++;
            }

            // 2. 스택 top이 x와 일치하지 않으면 불가능한 수열
            if (topIndex < 0 || stack[topIndex] != x) {
                sb.setLength(0);
                sb.append("NO\n");
                break;
            }

            // 3. 스택 top이 x라면 pop
            sb.append("-\n");
            topIndex--;
        }

        System.out.println(sb);
    }

}
