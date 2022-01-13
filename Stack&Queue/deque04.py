# 주식 가격
from collections import deque
def solution(prices):
    answer = []
    deq = deque(prices)
    while(deq):
        price = deq.popleft()
        time = 0
        for i in deq:
            time+=1
            if(price > i):
                break
        answer.append(time)
    return answer