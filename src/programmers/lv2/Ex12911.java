package programmers.lv2;

// 프로그래머스 Lv2. 다음 큰 숫자 - https://school.programmers.co.kr/learn/courses/30/lessons/12911
public class Ex12911 {

    public static void main(String[] args) {
        System.out.println(solution(78)); // 83
        System.out.println(solution(15)); // 23
    }

    // 효율성 테스트 실패
    public static int solution(int n) {
        int curOne = toBinary(n);

        while (true) {
            int nextOne = toBinary(++n);
            if (curOne == nextOne) {
                break;
            }
        }

        return n;
    }

    private static int toBinary(int n) {
        int one = 1;

        while (n > 1) {
            if (n % 2 == 1) {
                one++;
            }
            n /= 2;
        }

        return one;
    }

}

