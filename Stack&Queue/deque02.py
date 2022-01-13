# 프린터
from collections import deque

def solution(priorities, location):
    answer = 0
    deq = deque((j,i) for i, j in enumerate(priorities))
    while(deq):
        check = deq.popleft()
        if(deq and check[0] < max(deq)[0]):
            deq.append(check)
        else:
            answer+=1
            if(check[1] == location):
                break
        
            
    return answer