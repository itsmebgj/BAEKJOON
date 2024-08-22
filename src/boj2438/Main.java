package src.boj2438;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        for(int i = 1; i <= n; i++){
            for(int j = 0; j < i; j++){
                System.out.printf("*");
            }
            System.out.println();//줄바꿈 1번
        }//*을 i번씩 n번 치겠다(2중for문)
        scanner.close();
    }
}
//첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제