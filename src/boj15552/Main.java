package src.boj15552;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());  // 첫 번째 줄에서 테스트 케이스 수를 입력받습니다.

        for(int i = 0; i < T; i++) {
            String[] input = br.readLine().split(" ");  // 한 줄에서 두 정수를 읽어옴.
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            bw.write((a + b) + "\n");  // 결과를 출력.
        }

        bw.flush();  // 버퍼에 남아있는 데이터를 모두 출력합니다.
        bw.close();  // BufferedWriter를 닫습니다.
        br.close();  // BufferedReader를 닫습니다.
    }
}

/*
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int i = 0; i < T; i++ ){

            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println( a + b);
        }
        scanner.close();
    }
}
*/

/*
본격적으로 for문 문제를 풀기 전에 주의해야 할 점이 있다. 입출력 방식이 느리면 여러 줄을 입력받거나 출력할 때 시간초과가 날 수 있다는 점이다.
Java를 사용하고 있다면, Scanner와 System.out.println 대신 BufferedReader와 BufferedWriter를 사용할 수 있다. BufferedWriter.flush는 맨 마지막에 한 번만 하면 된다.
또한 입력과 출력 스트림은 별개이므로, 테스트케이스를 전부 입력받아서 저장한 뒤 전부 출력할 필요는 없다. 테스트케이스를 하나 받은 뒤 하나 출력해도 된다.
*/