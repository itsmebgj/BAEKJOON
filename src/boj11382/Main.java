package src.boj11382;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        long a, b, c;
        a = scanner.nextLong();
        b = scanner.nextLong();
        c = scanner.nextLong();

        System.out.println(a + b + c);

        scanner.close();
    }
}
//꼬마 정민이는 이제 A + B 정도는 쉽게 계산할 수 있다. 이제 A + B + C를 계산할 차례이다!