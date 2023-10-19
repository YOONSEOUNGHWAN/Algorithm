package hsat;

import java.util.Scanner;

/**
 * 로봇은 거리가 K 이하인 제품만 잡을 수 있다.
 * 로봇이 물건을 잡을 수 있는 최대 개수를 구하여라.
 */
public class 스마트물류 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.next();
        char[] arr = s.toCharArray();
        int answer = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == 'P'){
                for(int j=i-k; j<=i+k; j++){
                    if ((j >= 0 && j < n) && arr[j] == 'H') {
                        answer++;
                        arr[j] = 'X';
                        break;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
