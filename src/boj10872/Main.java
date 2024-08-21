package src.boj10872;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a;
        a = scanner.nextInt();

        System.out.println(factorial(a));
        /*
        int factorial = 1;

        for(int i=1; i<=a; i++){
            factorial *= i;
        }
        
        System.out.println(factorial);
        */
        scanner.close();
    }

    public static int factorial(int a){
        if (a == 1 || a == 0){
            return 1;}else{
                 return a * factorial(a-1);
            }
    }
}
//0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.