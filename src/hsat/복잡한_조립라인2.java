package hsat;

import java.util.Arrays;
import java.util.Scanner;

/**
 * K개의 조립라인이 존재한다.
 * 각 조립라인에는 N개의 작업장이 존재한다.
 * 같은 라인의 작업장은 동일한 작업을 수행하지만 수행시간이 다르다.
 * 1번 라인에서 최초 작업이 시작되며 작업이 종료되면 다음 작업이 가능하다.
 * 다음 작업시 다른 라인의 작업장으로 이동할 수 있다.
 * 가장 빠른 조립시간을 구하여라.
 */
public class 복잡한_조립라인2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int N = sc.nextInt();
        int[][] map = new int[N][K];
        //moveTime[0] -> 1번 작업장으로 가는데 걸리는 시간.
        int[] moveTime = new int[N - 1];
        for(int i=0; i<N; i++){
            for(int j=0; j<K; j++){
                map[i][j] = sc.nextInt();
            }
            if(i==N-1) break;
            moveTime[i] = sc.nextInt();
        }

        //2차원 dp 배열 탐색
        int[][] dp = new int[N][K];

        //초기화
        for(int j=0; j<K; j++){
            dp[0][j] = map[0][j];
        }

        //탐색
        for(int i=1; i<N; i++){
            int minValue = 987654321;
            for(int j=0; j<K; j++){
                minValue = Math.min(minValue, dp[i - 1][j]);
            }
            for(int j=0; j<K; j++){
                dp[i][j] = Math.min(dp[i - 1][j] + map[i][j], minValue + moveTime[i - 1] + map[i][j]);
            }
        }

        //정답 출력
        int answer = Arrays.stream(dp[N - 1]).min().getAsInt();
        System.out.println(answer);
    }
}
