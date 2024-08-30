package src.chatgpt.boj1025;

import java.util.Scanner;
public class Main {

    static int N, M;
    static char[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        board = new char[N][M];

        for (int i = 0; i < N; i++) {
            board[i] = sc.next().toCharArray();
        }

        int maxSquare = -1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int dRow = -N; dRow < N; dRow++) {
                    for (int dCol = -M; dCol < M; dCol++) {
                        if (dRow == 0 && dCol == 0) continue;

                        StringBuilder numStr = new StringBuilder();
                        int x = i, y = j;
                        while (x >= 0 && x < N && y >= 0 && y < M) {
                            numStr.append(board[x][y]);
                            int num = Integer.parseInt(numStr.toString());

                            if (isPerfectSquare(num)) {
                                maxSquare = Math.max(maxSquare, num);
                            }

                            x += dRow;
                            y += dCol;
                        }
                    }
                }
            }
        }

        System.out.println(maxSquare);
        sc.close();
    }

    private static boolean isPerfectSquare(int num) {
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }
}
/*
N행 M열의 표 A가 있고, 표의 각 칸에는 숫자가 하나씩 적혀있다.
연두는 서로 다른 1개 이상의 칸을 선택하려고 하는데, 행의 번호가 선택한 순서대로 등차수열을 이루고 있어야 하고, 열의 번호도 선택한 순서대로 등차수열을 이루고 있어야 한다. 이렇게 선택한 칸에 적힌 수를 순서대로 이어붙이면 정수를 하나 만들 수 있다.
연두가 만들 수 있는 정수 중에서 가장 큰 완전 제곱수를 구해보자. 완전 제곱수란 어떤 정수를 제곱한 수이다.
 */
