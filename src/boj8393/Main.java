package src.boj8393;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.close();
        long sum = n*(n+1)/2; //1~n까지의 합 공식
        System.out.println(sum);
    }
}


/*
n이 주어졌을 때, 1부터 n까지 합을 구하는 프로그램을 작성하시오.
 */