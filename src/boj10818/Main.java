package src.boj10818;

import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int arr[] = new int[n];

    for(int i =0; i<n; i++){
        arr[i] = sc.nextInt();    
    }
    Arrays.sort(arr);//Arrays.sort함수로 오름차순 정렬
    System.out.printf(arr[0]+ " " + arr[n-1]);//첫번재값 = 최솟값, 마지막값 = 최댓값출력

    sc.close();
    }
}
/*
N개의 정수가 주어진다. 이때, 최솟값과 최댓값을 구하는 프로그램을 작성하시오.
 */