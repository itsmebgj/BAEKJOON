package src.boj9086;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        for (int i = 0; i<n; i++){
            String s = scanner.next();
            System.out.printf("%s",s.charAt(0));
            System.out.println(s.charAt(s.length()-1));
        }//복잡하게 생각하지말고 charAt() 두번 각각 print
       
        scanner.close();
    }
}
//문자열을 입력으로 주면 문자열의 첫 글자와 마지막 글자를 출력하는 프로그램을 작성하시오.