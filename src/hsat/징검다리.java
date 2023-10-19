package hsat;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 서 <- 동 으로 징검다리가 존재한다.
 * 돌은 들쑥날쑥하다.
 * 서 <- 동 으로 점점 높은 돌을 밟으면서 개울을 지날 때, 최대 개수
 * 단, 돌은 건너 뛸 수 있다.
 */
public class 징검다리 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] bridge = new int[n];

        for(int i=0; i<n; i++){
            bridge[i] = sc.nextInt();
        }

        int[] dp = new int[n];
        for(int i=0; i<n; i++){
            dp[i] = 1;
        }

        for(int i=1; i<n; i++){
            //현재 바라보는 돌이 이전의 돌보다 높을 경우
            for(int j=0; j<i; j++){
                if(bridge[i] > bridge[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int answer = Arrays.stream(dp).max().getAsInt();
        System.out.println(answer);
    }

}
