package programmers.lv1;

// 프로그래머스 Lv1. 숫자 문자열과 영단어 - https://school.programmers.co.kr/learn/courses/30/lessons/81301
public class Ex81301 {

    public static void main(String[] args) {
        System.out.println(solution("one4seveneight")); // 1478
        System.out.println(solution("23four5six7")); // 234567
        System.out.println(solution("2three45sixseven")); // 234567
        System.out.println(solution("123")); // 123
    }

    public static int solution(String s) {
//        return Integer.parseInt(
//                s.replaceAll("zero", "0")
//                .replaceAll("one", "1")
//                .replaceAll("two", "2")
//                .replaceAll("three", "3")
//                .replaceAll("four", "4")
//                .replaceAll("five", "5")
//                .replaceAll("six", "6")
//                .replaceAll("seven", "7")
//                .replaceAll("eight", "8")
//                .replaceAll("nine", "9")
//        );

        String[] strArr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i < strArr.length; i++) {
            s = s.replaceAll(strArr[i], Integer.toString(i));
        }
        return Integer.parseInt(s);
    }

}
