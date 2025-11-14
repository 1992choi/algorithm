package fastcampus.codingpackage.part2.ch02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

/*
    [문제 핵심 아이디어]

    1) 목표
       - 각 위치 i에서, i 오른쪽에 있으면서 arr[i]보다 큰 값 중
         가장 가까운 값(오큰수, Next Greater Element)을 찾는 문제.
       - 단순 비교 시 O(N^2)이지만, 스택(또는 단조 감소 스택)을 사용하면 O(N)에 해결 가능.

    2) 접근 방식 (역순 + 단조 감소 스택)
       - 배열을 오른쪽 → 왼쪽으로 탐색하면서,
         “현재 값보다 큰 값들만 남기는” 단조 감소 스택을 유지한다.
       - 스택에는 ‘현재보다 오른쪽에 있는 큰 후보들’만 남게 된다.

    3) 동작 원리
       - i번째 요소를 처리할 때, 스택 top이 arr[i]보다 작거나 같으면 오른쪽에서 arr[i]보다 큰 후보가 될 수 없으므로 pop한다.
       - pop을 모두 끝내고 나면, 스택 top은 arr[i]보다 크면서 가장 가까운 오른쪽 값 = 오큰수.
       - 스택이 비어 있으면 오른쪽에 더 큰 값이 없다는 뜻이므로 -1 저장.
       - 현재 값 arr[i]는 앞으로 왼쪽 값의 후보가 되므로 스택에 push한다.

    4) 왜 단조 감소 스택인가?
       - 오른쪽에서 작은 값은 왼쪽 값의 오큰수가 될 수 없으므로 즉시 제거(pop)해도 된다.
       - 즉, 스택을 “내림차순”으로 유지하면서, 항상 가장 가까운 큰 값만 남게 된다.
       - POP은 각 요소가 최대 한 번만 일어나므로 전체 복잡도는 O(N).

    5) 예시
       arr = [3, 5, 2, 7]
       오른쪽부터 처리:

       i = 3 (7)
       - 스택 비어 있음 → 오큰수 = -1
       - push 7 → stack = [7]

       i = 2 (2)
       - top = 7 > 2 → 오큰수 = 7
       - push 2 → stack = [7, 2]

       i = 1 (5)
       - top = 2 ≤ 5 → pop → stack = [7]
       - top = 7 > 5 → 오큰수 = 7
       - push 5 → stack = [7, 5]

       i = 0 (3)
       - top = 5 > 3 → 오큰수 = 5
       - push 3 → stack = [7, 5, 3]

       결과: [5, 7, 7, -1]
*/
public class Ex17298 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] ans = new int[N];
        int[] descendingSequence = new int[N];
        int sequenceIndex = -1;

        for (int i = N - 1; i >= 0; i--) {
            while (sequenceIndex >= 0 && descendingSequence[sequenceIndex] <= arr[i])
                sequenceIndex--;

            ans[i] = (sequenceIndex < 0 ? -1 : descendingSequence[sequenceIndex]);
            descendingSequence[++sequenceIndex] = arr[i];
        }

        System.out.println(Arrays.stream(ans)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));
    }

}
