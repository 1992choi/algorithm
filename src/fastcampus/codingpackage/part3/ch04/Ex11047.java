package fastcampus.codingpackage.part3.ch04;

import java.util.Scanner;

/*
    풀이

    - 동전의 개수를 최소로 만들어야 하므로, 항상 "가장 큰 가치의 동전부터" 사용하는 그리디 전략을 사용한다.
    - 입력으로 주어지는 동전들은 오름차순이며, 문제 조건상 다음 조건이 항상 성립한다.
        * 각 동전은 이전 동전의 배수 관계로 구성됨
        * 따라서 큰 동전을 최대한 많이 쓰는 선택이 항상 최적해를 보장한다.

    - 핵심 아이디어
        1) 현재 금액 k보다 작거나 같은 가장 큰 동전을 찾는다.
        2) 해당 동전을 사용할 수 있는 최대 개수만큼 사용한다.
        3) 남은 금액(k)을 갱신하고, 다음 작은 동전으로 이동한다.
        4) k가 0이 될 때까지 반복한다.

    - 이 방식이 가능한 이유
        * 더 작은 동전 여러 개를 쓰는 것보다, 더 큰 동전 하나를 쓰는 것이 항상 동전 개수를 줄이기 때문
          (동전이 배수 관계일 때 가능)

    - 시간 복잡도
        O(n)
        (동전 종류 수만큼 한 번씩만 확인)
*/
class Ex11047 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int coin[] = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = sc.nextInt();
        }

        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (k >= coin[i]) {
                count += k / coin[i];
                k %= coin[i];
            }
        }
        System.out.println(count);
    }

}
