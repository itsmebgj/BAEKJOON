package src.boj2738;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int A[][] = new int[N][M];
        int B[][] = new int[N][M];
        int sum[][] = new int[N][M];

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                A[i][j] = scanner.nextInt();
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                B[i][j] = scanner.nextInt();
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                sum[i][j] = A[i][j]+B[i][j];
                System.out.printf("%d ",sum[i][j]);
            }
            System.out.println();
        }
        
        scanner.close();
    }
}
/*
N*M크기의 두 행렬 A와 B가 주어졌을 때, 두 행렬을 더하는 프로그램을 작성하시오.
 */