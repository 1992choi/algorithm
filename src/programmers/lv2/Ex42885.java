package programmers.lv2;

import java.util.Arrays;
import java.util.Comparator;

// 프로그래머스 Lv2. 구명보트 - https://school.programmers.co.kr/learn/courses/30/lessons/42885
public class Ex42885 {

    public static void main(String[] args) {
        System.out.println(solution2(new int[]{70, 50, 80, 50}, 100)); // 3
        System.out.println(solution2(new int[]{70, 80, 50}, 100)); // 3
        System.out.println(solution2(new int[]{50, 50, 50, 50}, 100)); // 2
        System.out.println(solution2(new int[]{20, 60, 70, 80, 30}, 100)); // 3
    }

    // 오답 - 테스트케이스 일부 오답
    public static int solution(int[] people, int limit) {
        int answer = 0;

        // 오름차순 정렬
        Arrays.sort(people);

        int lp = 0;
        int rp = people.length - 1;
        int sum = 0; // 몸무게 합
        int count = 0; // 태운 사람의 수. 최대 2명 태울 수 있음.

        while (lp < rp) {
            // 좌측 포인터 사람 태우기
            if (people[lp] + sum <= limit && count < 2) {
                sum += people[lp];
                people[lp] = 0;
                lp++;
                count++;
            }

            // 우측 포인터 사람 태우기
            if (people[rp] + sum <= limit && count < 2) {
                sum += people[rp];
                people[rp] = 0;
                rp--;
                count++;
            }

            if (count == 2 || (count == 1 && (limit < sum + people[lp]) && (limit < sum + people[rp]))) { // 더 이상 태울 수 없는 경우
                sum = 0;
                count = 0;
                answer++;
            }
        }

        if (Arrays.stream(people).sum() > 0) { // 못태운 한명이 있는지 확인
            answer++;
        }

        return answer;
    }

    // 오답 - 정확성 테스트 통과, 효율성 1개 제외(=시간 초과) 통과 : 오름차순을 내림차순으로만 변경하였음.
    public static int solution2(int[] people, int limit) {
        int answer = 0;

        // 내림차순 정렬
        people = Arrays.stream(people).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();

        int lp = 0;
        int rp = people.length - 1;
        int sum = 0; // 몸무게 합
        int count = 0; // 태운 사람의 수. 최대 2명 태울 수 있음.

        while (lp < rp) {
            // 좌측 포인터 사람 태우기
            if (people[lp] + sum <= limit && count < 2) {
                sum += people[lp];
                people[lp] = 0;
                lp++;
                count++;
            }

            // 우측 포인터 사람 태우기
            if (people[rp] + sum <= limit && count < 2) {
                sum += people[rp];
                people[rp] = 0;
                rp--;
                count++;
            }

            if (count == 2 || (count == 1 && (limit < sum + people[lp]) && (limit < sum + people[rp]))) { // 더 이상 태울 수 없는 경우
                sum = 0;
                count = 0;
                answer++;
            }
        }

        if (Arrays.stream(people).sum() > 0) { // 못태운 한명이 있는지 확인
            answer++;
        }

        return answer;
    }

}
