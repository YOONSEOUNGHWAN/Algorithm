package hsat;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * 소나기는 * 강은 X 로 표기되어 있다.
 * 집은 H, 세차장은 W
 *
 * 매 분마다 상,하,좌,우 이동가능하다.
 *
 * 소나기는 매 분마다 인접한 네 칸으로 확산한다.
 * 소나기는 강 또는 집에는 옮겨가지 않는다.
 * (강으로 가면 소멸)
 *
 * 세차장에서 출발하여 무사히 집으로 돌아오는 최소 시간을 구하여라
 *
 * 만약, 소나기를 피해 집에 올 수 없다면 FAIL을 출력하라.
 */
public class GINI야_도와줘 {
    static class Node{
        int x, y;
        int dist;
        boolean isRain;

        Node(int x, int y, int d, boolean b){
            this.x = x;
            this.y = y;
            this.dist = d;
            this.isRain = b;
        }
    }

    static int[][] D = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    static Node start;
    static Node end;
    static List<Node> RainList = new LinkedList<>();
    public static void main(String[] args) {
        //소나기를 먼저 확산한 다음
        //집으로 이동한다.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] map = new char[n][m];

        for(int i=0; i<n; i++){
            String tmp = sc.next();
            char[] chars = tmp.toCharArray();
            map[i] = chars;
            for(int j=0; j<chars.length; j++){
                if(chars[j] == '*'){
                    RainList.add(new Node(i, j, 0, true));
                }else if(chars[j] == 'W'){
                    start = new Node(i, j, 0, false);
                }else if(chars[j] == 'H'){
                    end = new Node(i, j, 0, false);
                }
            }
        }

        boolean[][] visited = new boolean[n][m];

        //비 먼저 이동 할 것.
        Queue<Node> myqueue = new LinkedList<>();
        for(Node rain : RainList){
            myqueue.offer(rain);
        }
        myqueue.offer(start);
        //탐색을 시작할 녀석
        visited[start.x][start.y] = true;

        int answer = 0;

        while(!myqueue.isEmpty()){
            //비 부터 채울 것임
            Node curr = myqueue.poll();
            if(curr.isRain){
                for(int i=0; i<4; i++){
                    int nx = curr.x + D[i][0], ny = curr.y + D[i][1];
                    //범위를 벗어나거나, 강을 만나거나, 집을 만날 경우 번지지 않는다.
                    if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    if(map[nx][ny] == 'X') continue;
                    if(map[nx][ny] == 'H') continue;
                    if(map[nx][ny] == '*') continue;
                    //퍼져나갈 수 있는 경우
                    map[nx][ny] = '*';
                    myqueue.offer(new Node(nx, ny, 0, true));
                }
            }else{

                if(curr.x == end.x && curr.y == end.y){
                    answer = curr.dist;
                    break;
                }
                //시작 지점에서 움직이기 시작할 것임.
                for(int i=0; i<4; i++){
                    int nx = curr.x + D[i][0], ny = curr.y + D[i][1];

                    if(nx < 0 || nx >=n || ny < 0 || ny >= m) continue;
                    if(visited[nx][ny]) continue;
                    if(map[nx][ny] == 'X' || map[nx][ny] == '*') continue;
                    //이동할 수 있는 경우
                    //이동 진행
                    visited[nx][ny] = true;
                    myqueue.offer(new Node(nx, ny, curr.dist + 1, false));
                }
            }
        }

        if(answer == 0){
            System.out.println("FAIL");
        }else{
            System.out.println(answer);
        }


    }

}
