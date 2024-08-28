package src.chatgpt.boj1107;

import java.util.Scanner;

public class Main {
    private static boolean[] broken = new boolean[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int target = sc.nextInt();  // 목표 채널
        int numBroken = sc.nextInt(); // 고장 난 숫자 버튼의 개수

        // 고장 난 숫자 버튼 입력
        for (int i = 0; i < numBroken; i++) {
            broken[sc.nextInt()] = true;
        }

        // 현재 채널이 100
        int minClicks = Math.abs(target - 100); // 기본적인 +, - 버튼을 사용할 경우 클릭 수

        // 채널 범위 설정
        for (int i = 0; i <= 1000000; i++) {
            String channel = Integer.toString(i);
            boolean isPossible = true;

            // 채널 번호에 사용 가능한 숫자 버튼이 있는지 체크
            for (int j = 0; j < channel.length(); j++) {
                if (broken[channel.charAt(j) - '0']) {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                int clicks = channel.length() + Math.abs(i - target);
                minClicks = Math.min(minClicks, clicks);
            }
        }

        System.out.println(minClicks);
        sc.close();
    }
}
/*
수빈이는 TV를 보고 있다. 수빈이는 채널을 돌리려고 했지만, 버튼을 너무 세게 누르는 바람에, 일부 숫자 버튼이 고장났다.

리모컨에는 버튼이 0부터 9까지 숫자, +와 -가 있다. +를 누르면 현재 보고있는 채널에서 +1된 채널로 이동하고, -를 누르면 -1된 채널로 이동한다. 채널 0에서 -를 누른 경우에는 채널이 변하지 않고, 채널은 무한대 만큼 있다.

수빈이가 지금 이동하려고 하는 채널은 N이다. 어떤 버튼이 고장났는지 주어졌을 때, 채널 N으로 이동하기 위해서 버튼을 최소 몇 번 눌러야하는지 구하는 프로그램을 작성하시오.

수빈이가 지금 보고 있는 채널은 100번이다.
 */