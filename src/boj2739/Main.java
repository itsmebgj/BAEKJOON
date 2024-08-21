package src.boj2739;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N;
        N = scanner.nextInt();
        for(int i=1; i<=9; i++){
            System.out.printf("%d * %d = %d%n", N, i, N * i);
        }

        scanner.close();
    }
}
//N을 입력받은 뒤, 구구단 N단을 출력하는 프로그램을 작성하시오. 출력 형식에 맞춰서 출력하면 된다.