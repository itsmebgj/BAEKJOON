package src.boj2562;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int max = 0; // 최댓값을 저장할 변수
        int index = 0; // 최댓값의 위치를 저장할 변수
        
        for (int i = 1; i <= 9; i++) {
            int num = scanner.nextInt(); // 숫자 입력
            if (num > max) {
                max = num;  // 새로운 최댓값으로 업데이트
                index = i;  // 최댓값의 위치 업데이트
            }
        }
        
        System.out.println(max); // 최댓값 출력
        System.out.println(index); // 최댓값의 위치 출력

        scanner.close();
    }
}
/*
import java.util.Arrays;

 Scanner sc = new Scanner(System.in);

        int arr[] = new int[9];
        for (int i = 0; i<9; i++){
            arr[i] = sc.nextInt();
        }//arr에 9개 수 입력받기
        sc.close();
        int originalarr[] = arr.clone();//배열의 복사본 생성

        Arrays.sort(arr);//정렬
        int n = arr[8];//최댓값저장
        System.out.println(n); //최댓값출력

        for(int i = 0; i<9; i++){
            if(originalarr[i] == n){
                System.out.println(i+1);
            } 
        }
 */
 /*
9개의 서로 다른 자연수가 주어질 때, 이들 중 최댓값을 찾고 그 최댓값이 몇 번째 수인지를 구하는 프로그램을 작성하시오.
예를 들어, 서로 다른 9개의 자연수
3, 29, 38, 12, 57, 74, 40, 85, 61
이 주어지면, 이들 중 최댓값은 85이고, 이 값은 8번째 수이다.
  */