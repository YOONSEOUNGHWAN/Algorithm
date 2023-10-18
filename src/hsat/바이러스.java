package hsat;

import java.util.Scanner;

/**
 * 1초당 P배씩 증가하는 바이러스
 *
 * 처음에 바이러스가 K마리 있었다면 N초 후에는 몇 마리가 존재할까
 * 1000000007 로 나눈 나머지를 출력하라
 * 재약 조건 -> 매우 큰 정수
 */
public class 바이러스 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int P = sc.nextInt();
        int N = sc.nextInt();

        //2 마리 3배 증가 2초 뒤
        //2 -> 6 -> 18

        long sum = K;
        for(int i=0; i<N; i++){
            sum = (sum*P) % 1000000007;
        }
        System.out.println("sum = " + sum);
    }
}
