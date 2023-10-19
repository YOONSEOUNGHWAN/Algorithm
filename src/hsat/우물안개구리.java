package hsat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * N명의 회원이 있다. 각 회원은 1~N
 * 회원이 들 수 있는 무게가 주어지고, 친분관계가 주어진다.
 * 친분관계를 연결해서 자신이 가장 무거운 무게면 최고다.
 * 최고라고 생각하는 회원은 몇명인가.
 */
public class 우물안개구리 {

    static int[] Parent;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] weightArray = new int[N];

        for (int i = 0; i < N; i++) {
            weightArray[i] = sc.nextInt();
        }
        boolean[] best = new boolean[N];
        for (int i = 0; i < N; i++) {
            best[i] = true;
        }
        int answer = 0;
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;

            if (weightArray[a] < weightArray[b]) {
                best[a] = false;
            } else if(weightArray[b] < weightArray[a]) {
                best[b] = false;
            }else{
                best[a] = best[b] = false;
            }
        }

        for (int i = 0; i < N; i++) {
            if (best[i]) answer++;
        }

        System.out.println(answer);

    }
}
