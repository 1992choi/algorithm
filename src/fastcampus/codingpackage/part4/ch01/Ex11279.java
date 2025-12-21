package fastcampus.codingpackage.part4.ch01;

import java.util.Scanner;

/*
  풀이

  - 핵심 아이디어
    - 최대 힙(Max Heap)을 배열로 직접 구현하여 우선순위 큐를 구성
    - 삽입 시에는 부모 노드와 비교하며 위로 올라가고, 삭제 시에는 자식 노드와 비교하며 아래로 내려감

  - 힙 구조
    - 완전 이진 트리를 배열로 표현
    - 인덱스 1부터 사용
    - 부모: i / 2, 왼쪽 자식: i * 2, 오른쪽 자식: i * 2 + 1

  - 연산 처리
    - push(x): 힙의 마지막에 값을 추가한 뒤 부모와 비교하며 위로 이동
    - pop(): 루트 값을 반환하고 마지막 원소를 루트로 옮긴 뒤 자식과 비교하며 아래로 이동
    - 힙이 비어 있을 경우 pop()은 0 반환

  - 시간 복잡도
    - push, pop 모두 O(log N)
*/
class Ex11279 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MaxPriorityQueue pq = new MaxPriorityQueue();
        int n = sc.nextInt();
        StringBuilder ans = new StringBuilder();
        while (n-- > 0) {
            int x = sc.nextInt();
            if (x == 0) {
                ans.append(pq.pop()).append('\n');
            } else {
                pq.push(x);
            }
        }
        System.out.println(ans);
    }

    static class MaxPriorityQueue {

        private int[] heap;
        private int size;

        public MaxPriorityQueue() {
            heap = new int[100001];
            size = 0;
        }

        public void push(int x) {
            heap[++size] = x;
            int current = size;
            while (current > 1) {
                int parent = current / 2;
                if (heap[parent] >= heap[current]) break;
                swap(parent, current);
                current = parent;
            }
        }

        public int pop() {
            if (size == 0) return 0;
            int ret = heap[1];
            heap[1] = heap[size--];
            int current = 1;
            while (current * 2 <= size) {
                int left = current * 2;
                int right = current * 2 + 1;
                int child = left;
                if (right <= size && heap[left] < heap[right]) {
                    child = right;
                }
                if (heap[current] >= heap[child]) break;
                swap(current, child);
                current = child;
            }
            return ret;
        }

        private void swap(int a, int b) {
            int tmp = heap[a];
            heap[a] = heap[b];
            heap[b] = tmp;
        }

    }

}
