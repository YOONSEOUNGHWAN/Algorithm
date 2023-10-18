package hsat;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 구간별 제한 속도가 주어진다.
 * 구간별 최고 초과 속도를 구하여라
 */
public class GBC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        //100미터 제한이 주어짐.
        int[] limit = new int[100];
        int idx = 0;
        for(int i=0; i<N; i++){
            int height = sc.nextInt();
            int restrict = sc.nextInt();
            while(height > 0){
                limit[idx++] = restrict;
                height--;
            }
        }
        idx = 0;
        for(int i=0; i<M; i++){
            int now = sc.nextInt();
            int speed = sc.nextInt();
            while(now > 0){
                int value = limit[idx];
                limit[idx++] = speed > value ? speed-value : 0;
                now--;
            }
        }

        int answer = Arrays.stream(limit).max().getAsInt();
        System.out.println(answer);

    }
}
