# 더 맵게
import heapq

def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)
    while(len(scoville) != 1):
        if(scoville[0] >= K):
            break
        answer+=1
        
        one = heapq.heappop(scoville)
        two = heapq.heappop(scoville)
        mix = one + two*2
        
        heapq.heappush(scoville, mix)
    
    if(scoville[0] < K):
        return -1
        
    return answer