package programmers.lv2;

import java.util.*;

// 프로그래머스 Lv2. 베스트앨범 - https://school.programmers.co.kr/learn/courses/30/lessons/42579
public class Ex42579 {

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        solution(
                                new String[]{"classic", "pop", "classic", "classic", "pop"},
                                new int[]{500, 600, 150, 800, 2500}
                        )
                )
        ); // [4, 1, 3, 0]
    }

    public static int[] solution(String[] genres, int[] plays) {
        // 장르별 총 재생횟수
        Map<String, Integer> genreTotalMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            genreTotalMap.put(genres[i], genreTotalMap.getOrDefault(genres[i], 0) + plays[i]);
        }

        // 장르별 재생횟수
        List<Album> genreList = new ArrayList<>();
        for (int i = 0; i < genres.length; i++) {
            genreList.add(new Album(i, genres[i], plays[i], genreTotalMap.get(genres[i])));
        }
        Collections.sort(genreList);

        // 앨범 만들기
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> genreMap = new HashMap<>();
        for (int i = 0; i < genreList.size(); i++) {
            int currentCnt = genreMap.getOrDefault(genreList.get(i).getGenre(), 0);
            if (currentCnt < 2) { // 가장 많이 재생된 노래 2개씩 모으기
                answer.add(genreList.get(i).getIdx());
                genreMap.put(genreList.get(i).getGenre(), currentCnt + 1);
            }
        }

        return answer.stream().mapToInt(x -> x).toArray();
    }

}

class Album implements Comparable<Album> {

    private int idx;
    private String genre;
    private int play;
    private int totalPlay;

    public Album(int idx, String genre, int play, int totalPlay) {
        this.idx = idx;
        this.genre = genre;
        this.play = play;
        this.totalPlay = totalPlay;
    }

    public int getIdx() {
        return idx;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public int compareTo(Album o) {
        return o.totalPlay == this.totalPlay ? (o.play == this.play ? this.idx - o.idx : o.play - this.play) : o.totalPlay - this.totalPlay;
    }

}
