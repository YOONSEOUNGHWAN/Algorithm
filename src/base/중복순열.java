package base;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 중복순열 {
    static List<int[]> answer = new LinkedList<>();
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        permutation(arr, new int[2], 0, 2);
        for(int[] i : answer){
            System.out.println("Arrays.toString(i) = " + Arrays.toString(i));
        }
    }

    static void permutation(int[] arr, int[] output, int depth, int r){
        if(depth == r){
            int[] tmp = new int[r];
            for(int i=0; i<r; i++){
                tmp[i] = output[i];
            }
            answer.add(tmp);
            return;
        }
        for(int i=0; i<arr.length; i++){
            output[depth] = arr[i];
            permutation(arr, output, depth + 1, r);
        }
    }
}
