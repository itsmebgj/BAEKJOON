package src.boj2525;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int m = sc.nextInt();
        int t = sc.nextInt();
        sc.close();
        
        m = m + t; //m += t; m에 요리시간 덧셈
        h = h + m / 60; //h += m / 60; m이 60이상일때 h증가
        m = m % 60; //m을 60으로 나눈 나머지
        h = h % 24; //h가 24 이상이면 0으로 되돌림

        System.out.println(h + " " + m);
/*
        if(m+t>60){
            h += 1;
            m = 60 - Math.abs(m+t);
            if(h>23){
                h = 0;
            }
            if(m==60 || m==-60){
                h += 1;
                m = 0;
            }
            System.out.println(h + " " + Math.abs(m));
        }else{
            System.out.println(h + " " +(m+t));
        }
 */
    }
}
