package fastcampus.codingpackage.part2.ch07;

import java.util.Scanner;

/*
    풀이
    - 분할 정복(Divide & Conquer)을 이용한 빠른 거듭제곱(Fast Power) 알고리즘
    - 핵심 원리:
        1) a^b는 b가 짝수일 때 a^b = (a^(b/2))^2 로 분해 가능
        2) b가 홀수일 때는 a^b = (a^(b/2))^2 * a 로 분해 가능
           → 지수의 성질: a^(x+y) = a^x * a^y
        3) 따라서 b를 절반씩 줄여 가면서 O(log b)에 계산 가능
        4) (A * B) % c = ((A % c) * (B % c)) % c 이므로
           계산 과정에서 꾸준히 mod c를 적용해 오버플로우를 방지함
    - a^b를 직접 계산하면 값이 매우 커지기 때문에,
      "쪼개고(mod하면서) 합치는 방식"이 필수적인 수학적 접근법
*/
class Ex1629 {

    public static int a, b, c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        System.out.println(power(a, b));
    }

    // 빠른 거듭제곱 함수: a^b % c
    public static long power(long a, long b) {
        if (b == 1) return a % c;

        long half = power(a, b / 2);
        // 절반으로 나누어 계산 → O(log b)

        if (b % 2 == 0) {
            // b가 짝수: a^b = (a^(b/2))^2
            return (half * half) % c;
        } else {
            // b가 홀수: a^b = (a^(b/2))^2 * a
            return (((half * half) % c) * a) % c;
        }
    }

}

