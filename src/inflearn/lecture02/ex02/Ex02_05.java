package inflearn.lecture02.ex02;

import java.util.*;

public class Ex02_05 {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2)); // daniel
        System.out.println(solution(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 2)); // john
        System.out.println(solution(new String[]{"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2)); // cody
        System.out.println(solution(new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"}, 3)); // luis
    }

    public static String solution(String[] votes, int k) {
        // 후보자 계산트
        Map<String, Integer> candidateMap = new HashMap<>();
        for (String s : votes) {
            String candidate = s.split(" ")[1]; // 후보자
            candidateMap.put(candidate, candidateMap.getOrDefault(candidate, 0) + 1);
        }

        // 투표자 계산
        Map<String, Integer> voterMap = new HashMap<>();
        for (String s : votes) {
            String voter = s.split(" ")[0]; // 투표자
            String candidate = s.split(" ")[1]; // 후보자

            if (candidateMap.getOrDefault(candidate, 0) >= k) { // 후보가 된 학생에게 투표한 투표자만 추출
                voterMap.put(voter, voterMap.getOrDefault(voter, 0) + 1);
            }
        }

        // 가장 많은 선물받은 학생 추출
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(voterMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2) {
                if (obj1.getValue() != obj2.getValue()) {
                    return obj2.getValue().compareTo(obj1.getValue()); // 감사 선물 순
                }

                // 이름 순
                return obj1.getKey().compareTo(obj2.getKey());
            }
        });

        return list.get(0).getKey();
    }

}
