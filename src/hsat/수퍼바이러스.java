package hsat;

import java.util.Scanner;

/**
 * 0.1초씩 P배씩 증가한다.
 * 처음에 K마리 존재한다.
 * N초 후에는 몇마리?
 */
public class 수퍼바이러스 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long K = sc.nextLong();
        int P = sc.nextInt();
        long N = sc.nextLong() * 10L;
        //N이 졸라크다. 10^16 즉 10자리 넘어감..

        long answer = power(P, N);
        K *= answer;
        K %= 1000000007;
        System.out.println(K);
    }

    static long power(int num, long cnt){
        if(cnt == 0) return 1;
        if(cnt == 1) return num;
        //재귀
        if(cnt % 2 == 0){
            long ret = power(num, cnt/2);
            return (ret*ret) % 1000000007;
        }else{
            long ret = power(num, (cnt-1) / 2);
            return (ret*ret) % 1000000007 * num % 1000000007;
        }
    }
}
