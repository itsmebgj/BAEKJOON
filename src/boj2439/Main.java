package src.boj2439;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 1; i<=n; i++){//1번줄~n번줄 까지 반복
            for(int j = n; j>i; j--){//각줄 앞부분 공백출력(n-1,n-2,n-3...)
                System.out.print(" ");
            }
            for(int j = 0; j < i; j++){//별 출력
                System.out.print("*");
            }
            System.out.println();//줄바꿈
        }
        sc.close();
    }
}
/*
첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제
하지만, 오른쪽을 기준으로 정렬한 별(예제 참고)을 출력하시오.
 */