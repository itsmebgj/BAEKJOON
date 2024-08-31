package src.chatgpt.boj11003;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        Deque<Integer> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < N; i++) {
            // 범위를 벗어난 인덱스 제거
            if (!deque.isEmpty() && deque.peekFirst() < i - L + 1) {
                deque.pollFirst();
            }
            
            // 현재 값보다 큰 값들 제거
            while (!deque.isEmpty() && A[deque.peekLast()] > A[i]) {
                deque.pollLast();
            }
            
            // 덱에 현재 인덱스 추가
            deque.offerLast(i);
            
            // 덱의 첫 번째 값이 최소값
            sb.append(A[deque.peekFirst()]).append(' ');
        }
        
        System.out.println(sb.toString().trim());
    }
}
/*
N개의 수 A1, A2, ..., AN과 L이 주어진다.
Di = Ai-L+1 ~ Ai 중의 최솟값이라고 할 때, D에 저장된 수를 출력하는 프로그램을 작성하시오. 이때, i ≤ 0 인 Ai는 무시하고 D를 구해야 한다.

덱 자료구조 사용
*/