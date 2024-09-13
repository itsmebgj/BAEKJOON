package src.boj11720;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();//N개의 숫자
        String numbers = sc.next();
        int sum =0;

        for(int i =0; i < N; i++){
            sum += numbers.charAt(i)-'0';//아스키코드 변환위해(정수변환 위해) -'0'(-48)
        }
        System.out.println(sum);

        sc.close();
    }   
}
/*
N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.
 */