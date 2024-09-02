package src.boj2884;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt(); //시
        int M = sc.nextInt(); //분
        sc.close();

        if(M < 45){
            H -= 1; //H 감소
            M = 60 - Math.abs(M-45); //60에 M-45의 절댓값 빼줌
            if (H < 0){
                H = 23; //H가 0보다 작아지면 23으로 복구
            }
            System.out.println(H + " " + M);
        }else{
            System.out.println(H + " " + (M - 45)); //H그대로, 그냥 M-45(M>=45)
        }  
    }
}
