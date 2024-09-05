import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        sc.close();

        if (a == b && b == c) {
            // 모두 같은 눈
            System.out.println(10000 + a * 1000);
        } else if (a == b || b == c || c == a) {
            // 같은 눈이 2개, 삼항연산자 (조건 ? 참일 때의 값 : 거짓일 때의 값)
            int repeatedValue = (a == b) ? a : (b == c ? b : c);
            /*
            첫 번째 조건 (a == b)
            만약 a가 b와 같다면, repeatedValue에 a의 값이 할당됩니다.
            첫 번째 조건이 거짓일 경우
            삼항 연산자의 : 뒤로 넘어가 다음 조건 (b == c ? b : c)가 평가됩니다.
            만약 b가 c와 같다면, b의 값이 할당되고, 그렇지 않다면 c의 값이 할당됩니다.
            */
            System.out.println(1000 + repeatedValue * 100);
        } else {
            // 모두 다른 눈, Math.max()사용해서 둘중 큰 수 출력
            int max = Math.max(a, Math.max(b, c));
            System.out.println(max * 100);
        }
    }
}//if , else if, else

/*
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        sc.close();

        if(a == b && b == c ){
            System.out.println(10000+a*1000);
        }//모두 같은 눈
        if(a == b && b != c){
           System.out.println(1000+a*100); 
        }
        if(b == c && c != a){
            System.out.println(1000+b*100);
        }
        if(c == a && a != b){
            System.out.println(1000+c*100);
        }//같은눈이 2개
        if(a != b && b != c && c != a){
            if(a>b && a>c){
                System.out.println(a*100);
            }
            if(b>a && b>c){
                System.out.println(b*100);
            }
            if(c>a && c>b){
                System.out.println(c*100);
            }
        }//모두 다른눈
    }
}
 */



/*
1에서부터 6까지의 눈을 가진 3개의 주사위를 던져서 다음과 같은 규칙에 따라 상금을 받는 게임이 있다.
같은 눈이 3개가 나오면 10,000원+(같은 눈)×1,000원의 상금을 받게 된다.
같은 눈이 2개만 나오는 경우에는 1,000원+(같은 눈)×100원의 상금을 받게 된다.
모두 다른 눈이 나오는 경우에는 (그 중 가장 큰 눈)×100원의 상금을 받게 된다.
예를 들어, 3개의 눈 3, 3, 6이 주어지면 상금은 1,000+3×100으로 계산되어 1,300원을 받게 된다. 또 3개의 눈이 2, 2, 2로 주어지면 10,000+2×1,000 으로 계산되어 12,000원을 받게 된다. 3개의 눈이 6, 2, 5로 주어지면 그중 가장 큰 값이 6이므로 6×100으로 계산되어 600원을 상금으로 받게 된다.
3개 주사위의 나온 눈이 주어질 때, 상금을 계산하는 프로그램을 작성 하시오.
 */