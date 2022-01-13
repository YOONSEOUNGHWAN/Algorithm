# 이중 우선순위 큐
import heapq
def solution(operations):
    answer = []
    heap = []
    
    for i in operations:
        #명령어 I 처리
        if i[0] == 'I':
            heapq.heappush(heap, int(i[2:]))
        #명령어 D 처리
        else:
            if len(heap)==0:
                continue
            elif i[2] == '-':
                heapq.heappop(heap)
            else:
                #heap에서 가장 큰 수 제거
                #heapq.nlargest(n, list) 함수를 사용하면 list에서 가장 큰 n개의 수를 뽑아 낼 수 있다. 위 코드에서 heap                     의 원소 개수만큼 뽑아 내기 때문에 heap 리스트는 내림 차순으로 정렬이 되어 있는 상태이다. 이 상태에서 1부터                     슬라이싱을 하면 가장 큰 최대값이 제외될 것이고, 다시 최소힙으로 만들어주면 된다.
                heap = heapq.nlargest(len(heap),heap)[1:]
                #다시 힙정렬
                heapq.heapify(heap)
    if heap:
        answer.append(max(heap))
        answer.append(min(heap))
    else:
        answer.append(0)
        answer.append(0)
            
    return answer