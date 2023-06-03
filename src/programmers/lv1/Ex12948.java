package programmers.lv1;

// 프로그래머스 Lv1. 핸드폰 번호 가리기 - https://school.programmers.co.kr/learn/courses/30/lessons/12948
public class Ex12948 {

    public static void main(String[] args) {
        System.out.println(solution("01033334444")); // *******4444
        System.out.println(solution("027778888")); // *****8888
    }

    public static String solution(String phone_number) {
        return phone_number.substring(0,phone_number.length() - 4).replaceAll(".", "*")
                + phone_number.substring(phone_number.length() - 4);
    }

}
