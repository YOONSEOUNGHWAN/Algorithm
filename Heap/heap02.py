# 디스크 컨트롤러
import heapq
def solution(jobs):
    count, answer, time = 0, 0, 0
    cur = -1
    heap = []
    while count < len(jobs):
        for s, t in jobs:
            if cur < s <= time:
                #제일 짧은 실행시간 추출하기 위해서..
                heapq.heappush(heap, (t,s))
        if len(heap) > 0:
            count+=1
            #현재 시간 갱신
            cur = time
            tmp, start = heapq.heappop(heap)
            time += tmp
            answer += time-start
        else:
            #못들어오면 진행..
            time+=1
    return answer//len(jobs)