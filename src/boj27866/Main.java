package src.boj27866;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int n = scanner.nextInt()-1;//인덱스는 0부터시작하기때문에 -1
        
        System.out.println(s.charAt(n));
        
        scanner.close();
    }
}
/*
단어 s와 정수 i가 주어졌을 때, s의 
i번째 글자를 출력하는 프로그램을 작성하시오.
 */