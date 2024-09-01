package src.boj2588;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextInt();
        long b = sc.nextInt();//세자리 분해
        long original_b = b;//b의 원래 값(while문 돌려야하기 때문에)

        while(b > 0){
            long digit = b % 10;// b의 일의자리
            System.out.println(a*digit);
            b = b / 10;//그 다음 자리
        }

        System.out.println(a*original_b);
        sc.close();
    }
}
/*
(세 자리 수) × (세 자리 수)는 다음과 같은 과정을 통하여 이루어진다.
(1)
(2)
(3)
(4)
(5) 
(6)
(1)과 (2)위치에 들어갈 세 자리 자연수가 주어질 때 (3), (4), (5), (6)위치에 들어갈 값을 구하는 프로그램을 작성하시오.
 */