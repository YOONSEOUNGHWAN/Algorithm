package base;

import java.util.Arrays;

public class 중복조합 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        combination(arr, new int[3], 0, 0, 3);
    }

    static void combination(int[] arr, int[] output, int start, int depth, int r){
        if(depth == r){
            System.out.println(Arrays.toString(output));
            return;
        }
        for(int i=start; i<arr.length; i++){
            output[depth] = arr[i];
            combination(arr, output, i, depth+1, r);
        }
    }
}
