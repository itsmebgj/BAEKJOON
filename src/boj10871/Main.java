package src.boj10871;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();//배열크기 입력받기
        int X = scanner.nextInt();//비교가 되는 기준 숫자
        int[] A = new int[N];//A배열 N크기 선언
        
        for (int i = 0; i < N; i++){
            A[i] = scanner.nextInt();//A배열에 N개의 정수를 입력시켜 저장
            if(A[i]<X){
                System.out.printf("%d"+" ", A[i]);
            }//X보다 작은수 출력
        }
        scanner.close();
    }
}
/*
첫째 줄에 N과 X가 주어진다. (1 ≤ N, X ≤ 10,000)
둘째 줄에 수열 A를 이루는 정수 N개가 주어진다. 주어지는 정수는 모두 1보다 크거나 같고, 10,000보다 작거나 같은 정수이다.
*/