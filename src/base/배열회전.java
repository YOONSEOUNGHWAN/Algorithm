package base;



public class 배열회전 {

    public static void main(String[] args) {

    }

    // 정사각형 90 도 회전 - 별도 배열 선언 필요 없음.
    static void rotate(int[][] map){
        int n = map.length;
        // #1 위아래
        for(int i=0; i<n/2; i++){
            for(int j=0; j<n; j++){
                int tmp = map[i][j];
                map[i][j] = map[n - i - 1][j];
                map[n - i - 1][j] = tmp;
            }
        }

        // #2 대각선 교환
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                int tmp = map[i][j];
                map[i][j] = map[j][i];
                map[j][i] = tmp;
            }
        }

    }

    //90 도 회전
    static int[][] rotate90(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;
        int[][] rotate = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                //0,0 -> n-1-j, i
                rotate[i][j] = arr[n-j-1][i];
            }
        }
        return rotate;
    }

    //180 도 회전
    static int[][] rotate180(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;
        int[][] rotate = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                rotate[i][j] = arr[n-i-1][m-j-1];
            }
        }
        return rotate;
    }
    //270도 회전
    static int[][] rotate270(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;
        int[][] rotate = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                //0,0 -> n-1-j, i
                rotate[i][j] = arr[j][m-i-1];
            }
        }
        return rotate;
    }
}
