package base;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * ['a', 'b', 'c']
 * [1, 2, 3]
 * 배열의 원소에서 순서를 고려하여 뽑는 경우의 수
 */
public class 순열 {
    static List<int[]> answer = new LinkedList<>();
    static List<int[]> answer2 = new LinkedList<>();
    public static void main(String[] args) {
        int[] indexArray = {1, 2, 3, 4};
        permutation(indexArray, 0,2);
        for(int[] tmp : answer){
            System.out.println("tmp = " + Arrays.toString(tmp));
        }

        permutation(indexArray, new int[3], new boolean[indexArray.length], 0, 3);

        for(int[] tmp : answer2){
            System.out.println("tmp = " + Arrays.toString(tmp));
        }
    }

    static void permutation(int[] arr, int[] output, boolean[] visited, int depth, int r){
        if(depth == r){
            int[] tmp = new int[r];
            for(int i=0; i<r; i++){
                tmp[i] = output[i];
            }
            answer2.add(tmp);
            return;
        }
        //방문 조건을 활용
        for(int i=0; i<arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                output[depth] = arr[i];
                permutation(arr, output, visited, depth + 1, r);
                visited[i] = false;
            }
        }
    }
    static void permutation(int[] arr, int depth, int r){
        //종료조건에 다가왔다면 정답칸에 담는다.
        if(depth == r){
            int[] tmp = new int[r];
            for(int i=0; i<r; i++){
                tmp[i] = arr[i];
            }
            answer.add(tmp);
            return;
        }
        //해당 깊이의 원소의 순서를 바꾼다.
        for(int i=depth; i<arr.length; i++){
            swap(arr, depth, i);
            permutation(arr, depth+1, r);
            //원위치
            swap(arr, depth, i);
        }
    }

    static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
