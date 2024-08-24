package src.boj10807;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();//정수의 개수        
        int Arr[] = new int[N];//둘째 줄 배열

        for (int i =0; i<N; i++){
            Arr[i] = scanner.nextInt();
        }

        int v = scanner.nextInt();//찾으려는 정수
        int count = 0;//동일한 정수개수

        for (int i=0; i<N; i++){
        if(Arr[i]==v){
            count++;
        }
    }
        System.out.println(count);

        scanner.close();
    }
}
/*
첫째 줄에 정수의 개수 N(1 ≤ N ≤ 100)이 주어진다. 
둘째 줄에는 정수가 공백으로 구분되어져있다. 
셋째 줄에는 찾으려고 하는 정수 v가 주어진다. 
입력으로 주어지는 정수와 v는 -100보다 크거나 같으며, 100보다 작거나 같다.
 */