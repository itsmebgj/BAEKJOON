package src.chatgpt.boj1038;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // N을 입력받는다.
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int N = scanner.nextInt();
        scanner.close();

        // 감소하는 수를 저장할 리스트를 만든다.
        List<Long> decreasingNumbers = new ArrayList<>();

        // 감소하는 수를 생성한다.
        for (int i = 0; i < 10; i++) {
            generateDecreasingNumbers(decreasingNumbers, i, 1);
        }

        // 감소하는 수들을 정렬한다.
        Collections.sort(decreasingNumbers);

        // N번째 감소하는 수를 출력한다.
        if (N < decreasingNumbers.size()) {
            System.out.println(decreasingNumbers.get(N));
        } else {
            System.out.println(-1);
        }
    }

    // 감소하는 수를 생성하는 재귀 함수
    public static void generateDecreasingNumbers(List<Long> list, long current, int length) {
        list.add(current);

        for (int i = 0; i < current % 10; i++) {
            generateDecreasingNumbers(list, current * 10 + i, length + 1);
        }
    }
}
/*
음이 아닌 정수 X의 자릿수가 가장 큰 자릿수부터 작은 자릿수까지 감소한다면, 그 수를 감소하는 수라고 한다. 예를 들어, 321과 950은 감소하는 수지만, 322와 958은 아니다. N번째 감소하는 수를 출력하는 프로그램을 작성하시오. 0은 0번째 감소하는 수이고, 1은 1번째 감소하는 수이다. 만약 N번째 감소하는 수가 없다면 -1을 출력한다.
 */