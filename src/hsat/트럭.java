package hsat;

import java.util.*;

/**
 * 소비자 N명에게 물어본다
 * 답변 = 제안의 개수 : 제안의 개수 * (크기 : 구매)
 * 시나리오 개수
 * 시나리오 크기
 */
public class 트럭 {
    static class Condition{
        int size, price;
        Condition(int size, int price){
            this.size = size;
            this.price = price;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<Integer, List<Integer>> sizeCustomer = new HashMap<>();
        List<List<Condition>> customerCondition = new LinkedList<>();
        int N = sc.nextInt();
        int maxSize = 0;
        for(int i=0; i<N; i++){
            //제안의 개수
            customerCondition.add(new LinkedList<>());
            int cnt = sc.nextInt();
            for(int j=0; j<cnt; j++){
                int size = sc.nextInt();
                maxSize = Math.max(maxSize, size);
                int pay = sc.nextInt();
                if(sizeCustomer.containsKey(size)){
                    sizeCustomer.get(size).add(i);
                }else{
                    List<Integer> customerNum = new LinkedList<>();
                    customerNum.add(i);
                    sizeCustomer.put(size, customerNum);
                }
                customerCondition.get(i).add(new Condition(size, pay));
            }
        }

        //sizeCustomer 정렬...? 굳이?
        int testCase = sc.nextInt();
        int[] answer = new int[testCase];
        for(int i=0; i<testCase; i++){
            int target = sc.nextInt();
            int suggestion = 1;
            while(suggestion <= maxSize){
                Set<Integer> buyCustomer = new HashSet<>();
                for(Map.Entry<Integer, List<Integer>> entry : sizeCustomer.entrySet()){
                    //구입할 수 있는 사람들
                    if(entry.getKey() <= suggestion){
                        List<Integer> value = entry.getValue();
                        for(int num : value){
                            buyCustomer.add(num);
                        }
                    }
                }

                int sum = 0;
                for(int customer : buyCustomer){
                    int maxPrice = 0;
                    List<Condition> conditions = customerCondition.get(customer);
                    for(Condition cond : conditions){
                        if(cond.size <= suggestion){
                            maxPrice = Math.max(maxPrice, cond.price);
                        }
                    }
                    sum += maxPrice;
                }

                if(sum >= target){
                    //해당 목표를 달성할 수 있는 신차의 크기가 정해진 것임.
                    answer[i] = suggestion;
                    break;
                } else if(suggestion == maxSize){
                    answer[i] = -1;
                    break;
                } else{
                    suggestion++;
                }
            }
        }

        for(int i=0; i<testCase; i++){
            System.out.print(answer[i] + " ");
        }
    }
}
