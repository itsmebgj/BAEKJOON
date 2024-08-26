package src.boj2744;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.next();
        String opposite = "";
        
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);       
                
            if(Character.isUpperCase(ch)){
                opposite = opposite + Character.toLowerCase(ch);
            }
            if(Character.isLowerCase(ch)){
                opposite = opposite + Character.toUpperCase(ch);
            }
        }

        System.out.println(opposite);
        scanner.close();
    }
}
//영어 소문자와 대문자로 이루어진 단어를 입력받은 뒤, 대문자는 소문자로, 소문자는 대문자로 바꾸어 출력하는 프로그램을 작성하시오.
