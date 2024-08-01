package programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

// 프로그래머스 Lv2. [1차] 캐시 - https://school.programmers.co.kr/learn/courses/30/lessons/17680
public class Ex17680 {

    public static void main(String[] args) {
        System.out.println(solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"})); // 50
        System.out.println(solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"})); // 21
        System.out.println(solution(2, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"})); // 60
        System.out.println(solution(5, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"})); // 52
        System.out.println(solution(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"})); // 16
        System.out.println(solution(0, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"})); // 25
    }

    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;

        Queue<String> cache = new LinkedList<>();
        for (String city : cities) {
            city = city.toLowerCase(); // 대소문자 구분X
            if (cache.contains(city)) { // HIT
                answer++;
                cache.remove(city); // 최근 참조된 것이므로 다시 넣었다 빼서 큐 맨뒤에 위치하도록 하기 위함
            } else { // MISS
                answer += 5;
                if (cache.size() >= cacheSize) { // 캐시크기를 초과한 경우는 오래된 것 제거
                    cache.poll();
                }
            }

            if (cacheSize != 0) { // 캐시크기가 0인 경우는 캐시에 넣지 않음
                cache.offer(city);
            }
        }

        return answer;
    }

}
