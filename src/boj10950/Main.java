package src.boj10950;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T;
        int a, b;

        T = scanner.nextInt();
        for(int i=0; i<T; i++){
            a = scanner.nextInt();
            b = scanner.nextInt();

            System.out.println(a+b);
        }

        scanner.close();
    }
}
//두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.