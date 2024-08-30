package src.chatgpt.boj1019;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] digitCounts = new int[10];
        
        // 각 자리수별로 숫자의 빈도를 계산
        countDigitOccurrences(N, digitCounts);
        
        // 결과를 한 줄로 출력
        for (int i = 0; i < 10; i++) {
            System.out.print(digitCounts[i] + " ");
        }
        sc.close();
    }
    
    private static void countDigitOccurrences(int N, int[] digitCounts) {
        for (int digit = 0; digit <= 9; digit++) {
            int count = 0;
            int factor = 1;
            int lowerNumbers = 0;
            int currentDigit = 0;
            int higherNumbers = 0;
            
            while (factor <= N) {
                higherNumbers = N / (factor * 10);
                currentDigit = (N / factor) % 10;
                lowerNumbers = N % factor;
                
                if (currentDigit < digit) {
                    count += higherNumbers * factor;
                } else if (currentDigit == digit) {
                    count += higherNumbers * factor + lowerNumbers + 1;
                } else {
                    count += (higherNumbers + 1) * factor;
                }
                
                if (digit == 0) {
                    count -= factor;
                }
                
                factor *= 10;
            }
            
            digitCounts[digit] = count;
        }
    }
}
/*
지민이는 전체 페이지의 수가 N인 책이 하나 있다. 첫 페이지는 1 페이지이고, 마지막 페이지는 N 페이지이다. 각 숫자가 전체 페이지 번호에서 모두 몇 번 나오는지 구해보자.
 */