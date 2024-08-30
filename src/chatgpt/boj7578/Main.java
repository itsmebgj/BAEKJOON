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
/*
어떤 공장에는 2N개의 기계가 2열에 걸쳐 N개씩 배치되어 있다. 이 2개의 열을 각각 A열과 B 열이라고 부른다. A열에 있는 N개의 기계는 각각이 B열에 있는 N개의 기계와 하나씩 짝을 이루어 케이블로 연결되어 있다. 즉, A열의 임의의 기계는 B열의 유일한 기계와 케이블로 연결되어 있고, B열의 임의의 기계는 A열의 유일한 기계와 케이블로 연결되어 있다
또한, 각 기계에는 식별번호가 붙어있으며, 짝이 맺어진 기계끼리는 같은 식별번호가 붙어있다. 즉, 각 열에 있는 N개의 기계끼리는 서로 다른 식별번호를 가지고 있으며, 반대쪽 열에 있는 같은 식별번호를 가진 기계와 케이블로 이어져 있다.
공장 작업의 효율성을 위해 기계들은 짝을 맺은 순서대로 배치되지 않으며, 필요에 따라 각 열의 기계들의 순서를 바꾼 바람에 케이블은 마구 엉켜있는 상태이다. 이렇게 엉켜버린 케이블은 잦은 고장의 원인이 되기 때문에, 기계의 위치를 바꾸지 않은 상태에서 케이블을 두 기계를 잇는 직선의 형태로 만들기로 했다.
예를 들어, 위의 그림과 같이 N = 5이고, A열에 위치한 기계의 식별번호가 순서대로 132, 392, 311, 351, 231이고 B열에 위치한 기계의 식별번호가 순서대로 392, 351, 132, 311, 231이라면 케이블들의 교차 횟수 혹은 서로 교차하는 케이블 쌍의 개수는 3이 된다.
정수 N과 A열에 위치한 기계, B열에 위치한 기계의 식별번호가 각각 순서대로 주어질 때에 서로 교차하는 케이블 쌍의 개수를 정확하게 세어 출력하는 프로그램을 작성하시오.
 */