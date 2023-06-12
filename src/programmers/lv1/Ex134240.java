package programmers.lv1;

// 프로그래머스 Lv1. 푸드 파이트 대회 - https://school.programmers.co.kr/learn/courses/30/lessons/134240
public class Ex134240 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 4, 6})); // 1223330333221
        System.out.println(solution(new int[]{1, 7, 1, 2})); // 111303111
    }

    public static String solution(int[] food) {
        StringBuilder answer = new StringBuilder();

        // 음식이 대칭으로 준비되었을 때, 한쪽 배치 구성하기
        for (int i = 1; i < food.length; i++) {
            for (int j = 0; j < food[i] / 2; j++) {
                answer.append(i);
            }
        }

        /*
            * 주의
        	    answer.reverse();와 answer.reverse().toString(); 사용 방법에 따라 결과값이 달라진다.
        	    그 이유는 toString()을 호출하면 새로운 문자열을 반환하지만,
                reverse()까지만 사용할 경우, 기존 문자열(먼저 구성한 한쪽 문자열)이 영향을 받아 같이 역순으로 구성된다.
                따라서 answer.reverse().toString();를 사용하지 않고, answer.reverse();를 사용한다면 의도한 결과가 나오지 않을 수 있다.
        */
        // return answer + "0" + answer.reverse(); // 오답코드
        return answer.toString() + "0" + answer.reverse();
    }

}