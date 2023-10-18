package hsat;

import java.util.Scanner;

/**
 * N명의 학생과 구간의 개수 M
 * 주어진 학생의 성적 평균을 구간별로 구하여라
 *
 */
public class 성적평균 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] sumArray = new int[N+1];
        for(int i=1; i<N+1; i++){
            int score = sc.nextInt();
            sumArray[i] = sumArray[i - 1] + score;
        }

        //0 10 60 80 150 250

        for(int i=0; i<M; i++){
            int start = sc.nextInt()-1;
            int end = sc.nextInt();
            int size = end - start;
            int sum = sumArray[end] - sumArray[start];
            double i1 = (double)sum / size;
            //소수점 2자리까지 출력
            System.out.printf("%.2f\n", i1);
            //소수점 2자리까지 저장
            //String.format("%.2f", i1);
        }
    }
}
