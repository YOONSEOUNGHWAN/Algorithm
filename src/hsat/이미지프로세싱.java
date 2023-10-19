package hsat;

import java.util.Scanner;

/**
 * 주어진 좌표에 대하여 해당 원소로 바꾸면 됨.
 */
public class 이미지프로세싱 {
    static int[][] Map;
    static int N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        N = n;
        M = m;
        int[][] map = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                map[i][j] = sc.nextInt();
            }
        }

        Map = map;

        int test = sc.nextInt();
        for(int t=0; t<test; t++){
            int i = sc.nextInt() - 1;
            int j = sc.nextInt() - 1;
            int target = sc.nextInt();
            int num = map[i][j];
            fill(i, j, num, target);
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(Map[i][j] + " ");
            }
            System.out.println();
        }
    }


    static void fill(int i, int j, int num, int target){
        //범위를 벗어나면 return
        if(i < 0 || i >= N || j < 0 || j >= M) return;
        if(Map[i][j] == target) return;
        if(Map[i][j] == num){
            Map[i][j] = target;
            fill(i-1, j, num, target);
            fill(i+1, j, num, target);
            fill(i, j-1, num, target);
            fill(i, j+1, num, target);
        }
    }

}
