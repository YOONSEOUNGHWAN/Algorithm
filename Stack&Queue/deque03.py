# 다리를 지나는 트럭
from collections import deque
def solution(bridge_length, weight, truck_weights):
    answer = 0
    bridege = deque([0 for _ in range(bridge_length)])
    total_weight = 0
    while(bridege):
        answer+=1
        total_weight -= bridege.popleft()
        if(truck_weights):
            if(total_weight + truck_weights[0]) <= weight:
                total_weight += truck_weights[0]
                bridege.append(truck_weights.pop(0))
            else:
                bridege.append(0)
    return answer