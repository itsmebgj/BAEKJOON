package src.chatgpt.boj1849;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] A;       // Inversion sequence 배열
    static int[] result;  // 결과 순열을 저장할 배열
    static FenwickTree fenwickTree;  // Fenwick Tree 객체

    public static void main(String[] args) throws IOException {
        // 입력 읽기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A = new int[N];
        result = new int[N];
        
        // Inversion sequence A 배열 입력 받기
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        
        // Fenwick Tree 초기화
        fenwickTree = new FenwickTree(N);
        // Fenwick Tree에 모든 위치를 사용 가능 상태로 설정
        for (int i = 1; i <= N; i++) {
            fenwickTree.update(i, 1);
        }

        // Inversion sequence를 처리하여 원래의 순열을 찾기
        for (int i = 0; i < N; i++) {
            int k = A[i] + 1;  // 1-based index로 변환
            // k번째로 작은 위치를 찾기
            int pos = fenwickTree.findKthSmallest(k);
            result[pos - 1] = i + 1;  // 결과 배열에 값 저장
            // 해당 위치를 사용 중으로 업데이트
            fenwickTree.update(pos, -1);
        }
        
        // 결과 순열 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append('\n');
        }
        System.out.print(sb.toString());
    }
    
    // Fenwick Tree 구현
    static class FenwickTree {
        int[] tree;   // Fenwick Tree의 내부 배열
        int size;     // Fenwick Tree의 크기

        public FenwickTree(int n) {
            size = n;
            tree = new int[n + 1];
        }

        // Fenwick Tree의 특정 인덱스 업데이트
        public void update(int index, int value) {
            while (index <= size) {
                tree[index] += value;
                index += (index & -index);
            }
        }

        // Fenwick Tree에서 특정 인덱스까지의 합 계산
        public int query(int index) {
            int sum = 0;
            while (index > 0) {
                sum += tree[index];
                index -= (index & -index);
            }
            return sum;
        }

        // k번째로 작은 값을 찾기
        public int findKthSmallest(int k) {
            int low = 1, high = size, mid;
            while (low < high) {
                mid = (low + high) / 2;
                if (query(mid) < k) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }
    }
}
/*
1부터 N까지의 수들이 한 번씩 쓰인 수열이 있다. 그 수열에서 i 앞에 있는 수 들 중, i보다 큰 수들의 개수를 A[i]라고 정의하자. A[i]가 주어져 있을 때, 원래 수열을 구하는 프로그램을 작성하여라. 

Fenwick Tree (Binary Indexed Tree, BIT) 사용
 */