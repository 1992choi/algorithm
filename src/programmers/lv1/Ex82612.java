package programmers.lv1;

import java.util.stream.LongStream;

// 프로그래머스 Lv1. 부족한 금액 계산하기 - https://school.programmers.co.kr/learn/courses/30/lessons/82612
public class Ex82612 {

    public static void main(String[] args) {
        System.out.println(solution(3, 20, 4)); // 10
    }

    public static long solution(int price, int money, int count) {
        long fee = LongStream.range(1, count + 1).map(index -> index * price).sum();
        return fee <= money ? 0 : fee - money;
    }

}
