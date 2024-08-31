package src.chatgpt.boj11658;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] bit, array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        array = new int[N + 1][N + 1];
        bit = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int value = Integer.parseInt(st.nextToken());
                array[i][j] = value;
                update(i, j, value);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());

            if (w == 0) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                int diff = c - array[x][y];
                array[x][y] = c;
                update(x, y, diff);
            } else if (w == 1) {
                int x1 = Integer.parseInt(st.nextToken());
                int y1 = Integer.parseInt(st.nextToken());
                int x2 = Integer.parseInt(st.nextToken());
                int y2 = Integer.parseInt(st.nextToken());

                int sum = query(x2, y2) - query(x1 - 1, y2) - query(x2, y1 - 1) + query(x1 - 1, y1 - 1);
                sb.append(sum).append('\n');
            }
        }

        System.out.print(sb.toString());
    }

    // 2D 펜윅 트리에서의 업데이트 함수
    static void update(int x, int y, int diff) {
        for (int i = x; i <= N; i += i & -i) {
            for (int j = y; j <= N; j += j & -j) {
                bit[i][j] += diff;
            }
        }
    }

    // 2D 펜윅 트리에서의 쿼리 함수
    static int query(int x, int y) {
        int sum = 0;
        for (int i = x; i > 0; i -= i & -i) {
            for (int j = y; j > 0; j -= j & -j) {
                sum += bit[i][j];
            }
        }
        return sum;
    }
}
/*
N×N개의 수가 N×N 크기의 표에 채워져 있다. 그런데 중간에 수의 변경이 빈번히 일어나고 그 중간에 어떤 부분의 합을 구하려 한다. 표의 i행 j열은 (i, j)로 나타낸다. (x1, y1)부터 (x2, y2)까지 합이란 x1 ≤ x ≤ x2, y1 ≤ y ≤ y2를 만족하는 모든 (x, y)에 있는 수의 합이다.
예를 들어, N = 4이고, 표가 아래와 같이 채워져 있는 경우를 살펴보자.
1	2	3	4
2	3	4	5
3	4	5	6
4	5	6	7
여기서 (2, 2)부터 (3, 4)까지 합을 구하면 3+4+5+4+5+6 = 27이 된다. (2, 3)을 7로 바꾸고 (2, 2)부터 (3, 4)까지 합을 구하면 3+7+5+4+5+6=30 이 된다.
표에 채워져 있는 수와 변경하는 연산과 합을 구하는 연산이 주어졌을 때, 이를 처리하는 프로그램을 작성하시오.

2D 펜윅 트리(BIT) 사용
 */