package src.boj10951;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 

        while(scanner.hasNext()){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            
            System.out.println(a+b);
        }//scanner.hasNext() -> 입력이 있을때 까지반복(종료시점제한)
        scanner.close();       
    }
    
}
//두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.