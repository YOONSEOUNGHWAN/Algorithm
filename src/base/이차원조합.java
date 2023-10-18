package base;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 이차원조합 {
    static List<List<int[]>> answer = new LinkedList<>();

    public static void main(String[] args) {
        int[][] map = new int[3][3];
        combination(map, new LinkedList<>(), 0, 0);
        for(List<int[]> i : answer){
            for(int[] e : i){
                System.out.print(Arrays.toString(e));
            }
            System.out.println();
        }
    }

    static void combination(int[][] map, List<int[]> output,  int start, int depth){
        if(depth == 2){
            List<int[]> tmp = new LinkedList<>();
            for(int[] e : output){
                tmp.add(e);
            }
            answer.add(tmp);
            return;
        }
        for(int i=start; i<3*3; i++){
            int x = i / 3, y= i % 3;
            if(map[x][y] == 0){
                map[x][y] = 1;
                output.add(new int[]{x, y});
                combination(map, output, i + 1, depth + 1);
                map[x][y] = 0;
                output.remove(output.size() - 1);
            }
        }
    }

}
