package src.chatgpt.boj1777;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] inversionSequence;
    static int[] result;
    static BIT bit;

    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        inversionSequence = new int[N];
        result = new int[N];
        
        // Inversion Sequence 입력 받기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inversionSequence[i] = Integer.parseInt(st.nextToken());
        }
        
        // BIT (Binary Indexed Tree) 초기화
        bit = new BIT(N);
        for (int i = 1; i <= N; i++) {
            bit.update(i, 1); // 모든 위치를 사용 가능한 상태로 표시
        }

        // 각 위치에 대해 순열의 올바른 값을 결정하기
        for (int i = N - 1; i >= 0; i--) {
            int k = inversionSequence[i] + 1; // 1-based 인덱스 k 계산
            int pos = bit.findKthSmallest(k); // k번째로 작은 위치 찾기
            result[pos - 1] = i + 1; // 결과 배열에 올바른 값 설정 (0-based 인덱스 조정)
            bit.update(pos, -1); // 해당 위치를 사용한 상태로 표시
        }
        
        // 결과 순열을 역순으로 출력하기
        StringBuilder sb = new StringBuilder();
        for (int i = N - 1; i >= 0; i--) {
            sb.append(result[i]).append(' ');
        }
        System.out.println(sb.toString().trim());
    }
    
    // BIT (Binary Indexed Tree) 구현
    static class BIT {
        int[] tree;
        int size;

        // BIT 생성자
        public BIT(int n) {
            size = n;
            tree = new int[n + 1];
        }

        // 인덱스 위치의 값 업데이트 (값 더하기)
        public void update(int index, int value) {
            while (index <= size) {
                tree[index] += value;
                index += (index & -index);
            }
        }

        // 인덱스 위치까지의 누적 합을 반환
        public int query(int index) {
            int sum = 0;
            while (index > 0) {
                sum += tree[index];
                index -= (index & -index);
            }
            return sum;
        }

        // k번째로 작은 위치를 찾는 함수
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
1부터 N번까지로 수로 이루어진 순열이 있다.
그리고 이 순열과 연관된 "Inversion sequence"라고 부르는 수열이 있다. 이 수열의 i번째 원소에는 순열에서 i보다 뒤에 나오면서 i보다 작은 수의 개수가 들어간다.
2  4  5  1  7  6  3  8
위의 순열이 있다면 이것의 Inversion sequence는
0  1  0  2  2  1  2  0 이 된다.
문제는 역으로 어떤 Inversion sequence가 주어지면 이것에 해당하는 순열을 찾는 프로그램을 작성하는 것이다.

Fenwick Tree (Binary Indexed Tree, BIT)사용
*/