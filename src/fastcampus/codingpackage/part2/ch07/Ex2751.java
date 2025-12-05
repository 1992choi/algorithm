package fastcampus.codingpackage.part2.ch07;

import java.util.Scanner;

/*
    풀이

    - 병합 정렬(Merge Sort)을 이용해 정렬
      - 배열을 절반으로 분할해 각각 정렬한 뒤, 두 정렬된 배열을 병합하는 방식으로 수행된
    - 시간 복잡도는 O(n log n)으로, 입력 크기가 큰 문제에 적합한 정렬 방식이다.
*/
class Ex2751 {

    static int n;
    static int[] numbers;
    static int[] temp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        numbers = new int[n];
        temp = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        divide(0, n - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(numbers[i]).append("\n");
        }
        System.out.println(sb);
    }

    // 배열을 반으로 나누고 각각 정렬하는 분할 과정
    static void divide(int start, int end) {
        if (start == end) return;

        int mid = (start + end) / 2;
        divide(start, mid);
        divide(mid + 1, end);
        combine(start, end);
    }

    // 두 정렬된 구간 [start ~ mid], [mid+1 ~ end]를 병합
    static void combine(int start, int end) {
        int mid = (start + end) / 2;
        int left = start;
        int right = mid + 1;
        int newIdx = start;

        while (left <= mid && right <= end) {
            if (numbers[left] < numbers[right]) {
                temp[newIdx++] = numbers[left++];
            } else {
                temp[newIdx++] = numbers[right++];
            }
        }

        while (left <= mid) {
            temp[newIdx++] = numbers[left++];
        }

        while (right <= end) {
            temp[newIdx++] = numbers[right++];
        }

        // 병합한 결과를 원본 배열로 복사
        for (int i = start; i <= end; i++) {
            numbers[i] = temp[i];
        }
    }

}
