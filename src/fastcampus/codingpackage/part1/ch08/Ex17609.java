package fastcampus.codingpackage.part1.ch08;

import java.util.Scanner;

public class Ex17609 {

    // 문자열의 부분 구간 [l, r]이 회문인지 확인하는 함수
    static boolean isPalindrome(char[] str, int l, int r) {
        while (l <= r) { // 양쪽 끝에서부터 비교
            if (str[l] != str[r]) return false; // 하나라도 다르면 회문이 아님
            l++;
            r--;
        }
        return true; // 모두 같으면 회문
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // 테스트 케이스 개수 입력
        while (T-- > 0) { // 테스트 케이스 반복
            char[] str = sc.next().toCharArray(); // 문자열을 문자 배열로 변환
            int ans = 0; // 결과값 (0: 회문, 1: 유사회문, 2: 그 외)
            int l = 0, r = str.length - 1; // 양 끝 인덱스 초기화

            while (l <= r) {
                if (str[l] != str[r]) { // 양쪽 문자가 다르면 회문이 아님
                    // 왼쪽 문자 하나 제거 or 오른쪽 문자 하나 제거 후 회문이 되는지 검사
                    if (isPalindrome(str, l + 1, r) || isPalindrome(str, l, r - 1))
                        ans = 1; // 한 글자 제거로 회문 가능 → 유사회문
                    else
                        ans = 2; // 한 글자 제거로도 회문 불가능 → 일반 문자열
                    break; // 더 이상 비교할 필요 없음
                }
                l++; // 왼쪽 포인터 이동
                r--; // 오른쪽 포인터 이동
            }

            System.out.println(ans); // 결과 출력
        }
    }

}
