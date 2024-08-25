package src.boj11654;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int Ch = scanner.next().charAt(0);
        //사용자가 입력한 첫번째 문자의 아스키코드 값이라 int Ch
        System.out.println(Ch);

        scanner.close();

    }
}
//알파벳 소문자, 대문자, 숫자 0-9중 하나가 주어졌을 때, 주어진 글자의 아스키 코드값을 출력하는 프로그램을 작성하시오.