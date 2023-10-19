package hsat;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 레일 N 개가 주어지고, 각 레일은 무게가 정해져있다.
 *
 * 택배 바구니 무게 M 을 넘어가지 않도록 담아서 이동하면 1회 이동
 *
 * K번 일을 할 경우 최소한이 무게로 일을 할 수 있도록
 * 최소한의 무게를 출력하라.
 */
public class 택배마스터광우 {
    static List<int[]> Candidates = new LinkedList<>();

    public static void main(String[] args) {
        //N개의 레일의 범위는 3 ~ 10
        //완탐으로 가능하지 않을까..
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        permutation(arr, 0, arr.length);

        int answer = 987654321;

        for(int[] candi : Candidates){
            answer = Math.min(answer, solve(M, K, candi));
        }
        System.out.println(answer);
    }

    static int solve(int weight, int count, int[] arr){
        int idx = 0;
        int ret = 0;
        for(int i=0; i<count; i++){
            int sum = 0;
            while(arr[idx] + sum <= weight){
                sum += arr[idx];
                idx = (idx + 1) % arr.length;
            }
            ret += sum;
        }
        return ret;
    }

    static void permutation(int[] arr, int depth, int recursive){
        if(depth == recursive){
            int[] tmp = new int[arr.length];
            for(int i=0; i<arr.length; i++){
                tmp[i] = arr[i];
            }
            Candidates.add(tmp);
            return;
        }

        for(int i=depth; i<arr.length; i++){
            swap(arr, depth, i);
            permutation(arr, depth + 1, recursive);
            swap(arr, depth, i);
        }
    }

    static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


}
