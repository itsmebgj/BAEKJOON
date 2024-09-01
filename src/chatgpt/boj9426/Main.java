package src.chatgpt.boj9426;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] temperatures = new int[N];
        for (int i = 0; i < N; i++) {
            temperatures[i] = Integer.parseInt(br.readLine());
        }
        
        // 최대 힙과 최소 힙을 사용하여 중앙값 추적
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        long sumOfMedians = 0;

        for (int i = 0; i < N; i++) {
            if (maxHeap.size() <= minHeap.size()) {
                minHeap.offer(temperatures[i]);
                maxHeap.offer(minHeap.poll());
            } else {
                maxHeap.offer(temperatures[i]);
                minHeap.offer(maxHeap.poll());
            }
            
            if (maxHeap.size() + minHeap.size() == K) {
                // 중앙값 계산
                sumOfMedians += maxHeap.peek();
                
                // 슬라이딩 윈도우에서 빠지는 값을 처리
                int removeElement = temperatures[i - K + 1];
                if (!maxHeap.remove(removeElement)) {
                    minHeap.remove(removeElement);
                }
                
                // 힙 크기 재조정
                if (maxHeap.size() < minHeap.size()) {
                    maxHeap.offer(minHeap.poll());
                }
            }
        }
        
        System.out.println(sumOfMedians);
    }
}
/*
기상학에서 주요 사용하는 대표값은 중앙값이다. (중앙값의 정의는 힌트에 나와있다)
상근이는 1초에 한 번씩 온도를 재는 기계를 가지고 있고, 이 기계에 들어갈 소프트웨어를 작성하려고 한다. 기계에는 작은 디지털 디스플레이가 하나 달려있다. 매 초마다 디스플레이는 지난 K초동안 측정한 온도의 중앙값을 화면에 보여준다.
상근이는 소프트웨어를 기계에 올리기 전에 컴퓨터에서 테스트해보려고 한다.
총 N초 동안 측정한 온도가 주어졌을 때, 디스플레이에 표시된 중앙값의 합을 구하는 프로그램을 작성하시오. 즉, N개의 수가 주어졌을 때, 길이가 K인 연속 부분 수열 N-K+1개의 중앙값의 합을 구하는 프로그램을 작성하시오.

우선순위 큐(Priority Queue) 사용
 */