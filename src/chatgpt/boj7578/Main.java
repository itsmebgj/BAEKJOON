package src.chatgpt.boj7578;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] A, B;
    static int[] position;
    static int[] temp;
    
    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        
        A = new int[N];
        B = new int[N];
        
        // A열의 기계 식별번호 입력 받기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        // B열의 기계 식별번호 입력 받기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        
        // Step 1: B열의 각 기계 식별번호 위치 매핑하기
        position = new int[N];
        Map<Integer, Integer> map = new HashMap<>();
        
        // B열의 각 식별번호와 그 위치를 저장
        for (int i = 0; i < N; i++) {
            map.put(B[i], i);
        }
        
        // A열의 각 기계 식별번호가 B열의 어떤 위치에 있는지 배열로 변환
        for (int i = 0; i < N; i++) {
            position[i] = map.get(A[i]);
        }
        
        // Step 2: position 배열에서 역수의 개수 계산하기
        temp = new int[N];
        long inversions = mergeSort(position, 0, N - 1);
        
        // 결과 출력
        System.out.println(inversions);
    }
    
    // Merge Sort를 이용해 역수의 개수를 계산하는 함수
    private static long mergeSort(int[] array, int left, int right) {
        if (left >= right) {
            return 0;
        }
        
        // 배열을 반으로 나누기
        int mid = (left + right) / 2;
        long count = mergeSort(array, left, mid) + mergeSort(array, mid + 1, right);
        
        // 나눈 배열을 병합하면서 역수의 개수 계산하기
        count += merge(array, left, mid, right);
        
        return count;
    }
    
    // 두 부분 배열을 병합하며 역수의 개수를 계산하는 함수
    private static long merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        
        // 배열을 부분 배열로 나누기
        System.arraycopy(array, left, leftArray, 0, n1);
        System.arraycopy(array, mid + 1, rightArray, 0, n2);
        
        int i = 0, j = 0, k = left;
        long inversions = 0;
        
        // 병합하면서 역수의 개수 계산하기
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
                inversions += n1 - i;  // 역수의 개수 추가
            }
        }
        
        // 남은 부분 배열을 복사하기
        while (i < n1) {
            array[k++] = leftArray[i++];
        }
        
        while (j < n2) {
            array[k++] = rightArray[j++];
        }
        
        return inversions;
    }
}
