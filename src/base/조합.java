package base;

/**
 * 조합의 경우 int -> 32가지 조합 가능.
 * long -> 64까지..근데 이렇게 많은 경우는 사용하지 않음
 * [1,2,3,4] -> 중복 제외 조합 뽑기
 */
public class 조합 {
    public static void main(String[] args) {
        int[] indexArray = {1,2,3,4,5};
        //100000 바로 직전인 0 11111까지 비트가 켜져있는지 확인한다.
        for(int i=0; i<(1 << indexArray.length); i++){
            //3가지 조합인 경우
            if(Integer.bitCount(i) == 2){
                for(int j=0; j<indexArray.length; j++){
                    if((i & (1 << j)) != 0){
                        //j번째 인덱스가 켜진것임.
                        System.out.print(indexArray[j] + " ");
                    }
                }
                System.out.println();
            }
        }

        ///////////////////////////////////////////////////////
        System.out.println("//////////////////////////////////////");
        combination(indexArray, new boolean[indexArray.length], 0, 3);
        System.out.println("//////////////////////////////////////");
        combination2(indexArray, new boolean[indexArray.length], 0, 3);
    }

    static void combination(int[] arr, boolean[] visited, int start, int r){
        if(r == 0){
            for(int i=0; i<arr.length; i++){
                if(visited[i]) System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i=start; i<arr.length; i++){
            visited[i] = true;
            combination(arr, visited, i + 1, r - 1);
            visited[i] = false;
        }
    }

    static void combination2(int[] arr, boolean[] visited, int depth, int r){
        if(r == 0){
            for(int i=0; i<arr.length; i++){
                if(visited[i]) System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        if(depth == arr.length) return;
        //해당 원소를 선택하고 -> 다음 원소를 고른다.
        visited[depth] = true;
        combination2(arr, visited, depth + 1, r-1);

        //해당 원소를 skip 한다.
        visited[depth] = false;
        combination2(arr, visited, depth + 1, r);
    }

}
