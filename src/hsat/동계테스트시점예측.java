package hsat;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * 2변 이상이 외부와 접촉하면 한시간만에 없어진다.
 * 얼음 내부 공간은 공기와 접촉하지 않은 것으로 간주한다.
 * 가장자리에는 얼음이 놓이지 않는 것으로 간주한다.
 * 모든 얼음이 녹는 시간을 구하여라.
 */
public class 동계테스트시점예측 {
    //bfs탐색을 활용하여 벽면으로 나아갈 수 있는지 확인..?
    //단, 최단거리 탐색을 활용하므로 일직선 방향응로만 이동한다.
    static int N, M;
    static int[][] D = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        N = n;
        M = m;
        int[][] map = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int block = sc.nextInt();
                if(block == 1) map[i][j] = 1;
                else map[i][j] = 0;
            }
        }
        //가장 자리는 9임.
        //얼음이 다 녹을 때 까지.
        int answer = 1;
        while(!finish(map)){
            List<int[]> eraseList = new LinkedList<>();
            canErase(map, eraseList);
            for(int[] erase : eraseList){
                int x = erase[0], y = erase[1];
                map[x][y] = 0;
            }
            answer++;
        }

        System.out.println(answer);


    }

    static void canErase(int[][] map, List<int[]> list){
        Queue<int[]> myqueue = new LinkedList<>();
        myqueue.offer(new int[]{0, 0});
        int[][] visited = new int[N][M];
        visited[0][0] = 1;

        while (!myqueue.isEmpty()) {
            int[] curr = myqueue.poll();
            int x = curr[0], y = curr[1];
            //상하좌우 탐색
            for(int i=0; i<4; i++){
                int nx = x + D[i][0], ny = y + D[i][1];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                //얼음 공간이면 ++
                if(map[nx][ny] == 1){
                    visited[nx][ny]++;
                    if(visited[nx][ny] >= 2) list.add(new int[]{nx, ny});
                }else if(visited[nx][ny] == 0){
                    myqueue.offer(new int[]{nx, ny});
                    visited[nx][ny] = 1;
                }
            }
        }
    }

    static boolean finish(int[][] map){
        for(int i=1; i<N-1; i++){
            for(int j=1; j<M-1; j++){
                if(map[i][j] != 0) return false;
            }
        }
        return true;
    }
}
