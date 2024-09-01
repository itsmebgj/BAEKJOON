package src.chatgpt.boj14733;

import java.util.*;

public class Main {
    static class Event implements Comparable<Event> {
        int x, y1, y2, type;
        Event(int x, int y1, int y2, int type) {
            this.x = x;
            this.y1 = y1;
            this.y2 = y2;
            this.type = type;
        }
        @Override
        public int compareTo(Event o) {
            return this.x - o.x;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Event[] events = new Event[2 * N];
        Set<Integer> ySet = new HashSet<>();

        for (int i = 0; i < N; i++) {
            int x1 = sc.nextInt(), y1 = sc.nextInt();
            int x2 = sc.nextInt(), y2 = sc.nextInt();
            events[2 * i] = new Event(x1, y1, y2, 1);  // 시작 이벤트
            events[2 * i + 1] = new Event(x2, y1, y2, -1);  // 종료 이벤트
            ySet.add(y1);
            ySet.add(y2);
        }

        // y 좌표들을 압축합니다.
        List<Integer> yList = new ArrayList<>(ySet);
        Collections.sort(yList);
        Map<Integer, Integer> yMap = new HashMap<>();
        for (int i = 0; i < yList.size(); i++) {
            yMap.put(yList.get(i), i);
        }

        int[] count = new int[yList.size() - 1];
        int[] yLength = new int[yList.size() - 1];
        Arrays.sort(events);

        long totalArea = 0;
        for (int i = 0; i < events.length; i++) {
            if (i > 0) {
                int xDiff = events[i].x - events[i - 1].x;
                long currentArea = 0;
                for (int j = 0; j < yList.size() - 1; j++) {
                    if (count[j] > 0) {
                        currentArea += yLength[j];
                    }
                }
                totalArea += currentArea * xDiff;
            }

            int yStart = yMap.get(events[i].y1);
            int yEnd = yMap.get(events[i].y2);
            for (int j = yStart; j < yEnd; j++) {
                count[j] += events[i].type;
                yLength[j] = yList.get(j + 1) - yList.get(j);
            }
        }

        System.out.println(totalArea);
        sc.close();
    }
}
/*
상현이는 국방부 퀘스트를 수행하기 전에 이별 파티를 기획하고 있다. 따라서 파티를 진행하기 위해 행사장을 대여하려고 한다.
이 대여 업체는 전직 프로그래머들만 일하기 때문에 대여 방식이 독특하다. 상현이가 대여 장소를 정하면 그 장소를 완전히 포갤 수 있는 N개의 직사각형을 만든다. 그 후 직사각형의 개수 N과 각 직사각형들의 좌측 하단과 우측 상단의 좌표를 알려준다. N개의 직사각형들은 일부분 혹은 전체가 겹칠 수도 있다.
상현이가 빌린 행사장의 넓이를 구하는 프로그램을 작성하라.

이벤트 스위핑 기법 사용
 */