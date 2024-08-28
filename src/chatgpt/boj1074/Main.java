package src.chatgpt.boj1074;

import java.util.Scanner;

public class Main {
    
    public static int findZOrder(int N, int r, int c) {
        int size = 1 << N; // 2^N
        int order = 0;
        
        while (size > 1) {
            size >>= 1;
            int quadrant = (r / size) * 2 + (c / size);
            int offset = quadrant * size * size;
            order += offset;
            
            // Update (r, c) to the new quadrant
            if (r >= size) {
                r -= size;
            }
            if (c >= size) {
                c -= size;
            }
        }
        
        return order;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        scanner.close();
        
        System.out.println(findZOrder(N, r, c));
    }
}
/*
한수는 크기가 2^N × 2^N인 2차원 배열을 Z모양으로 탐색하려고 한다. 예를 들어, 2×2배열을 왼쪽 위칸, 오른쪽 위칸, 왼쪽 아래칸, 오른쪽 아래칸 순서대로 방문하면 Z모양이다.
N = 2 인 경우, 배열을 크기가 2^(2-1) × 2^(2-1)로 4등분 한 후에 왼쪽위 네개부터 오른쪽위 네개, 왼쪽아래 네개, 오른쪽 아래 네개순서로 재귀적으로 순서대로 방문한다.
N이 주어졌을 때, r행 c열을 몇 번째로 방문하는지 출력하는 프로그램을 작성하시오.
 */