package inflearn.lecture02.ex08;

import java.util.*;

public class Ex08_06_Answer {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"english", "math", "physics", "art", "music"}, new String[]{"art math", "physics art", "art music", "physics math", "english physics"}))); // ["math", "music", "art", "physics", "english"]
        System.out.println(Arrays.toString(solution(new String[]{"art", "economics", "history", "chemistry"}, new String[]{"chemistry history", "economics history", "art economics"}))); // ["history", "chemistry", "economics", "art"]
        System.out.println(Arrays.toString(solution(new String[]{"math", "science", "music", "biology"}, new String[]{"science music", "math music", "math science", "biology math"}))); // ["music", "science", "math", "biology"]
    }

    public static String[] solution(String[] subjects, String[] course) {
        int n = subjects.length;
        HashMap<String, Integer> node = new HashMap<>();
        for (int i = 0; i < n; i++) node.put(subjects[i], i);
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        int[] indegree = new int[n];
        for (String x : course) {
            int a = node.get(x.split(" ")[0]);
            int b = node.get(x.split(" ")[1]);
            graph.get(b).add(a);
            indegree[a]++;
        }

        ArrayList<Integer> order = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            order.add(pre);
            for (int x : graph.get(pre)) {
                indegree[x]--;
                if (indegree[x] == 0) {
                    queue.offer(x);
                }
            }
        }
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            answer[i] = subjects[order.get(i)];
        }
        return answer;
    }

}