# H-Index
def solution(citations):
    answer = 0
    n=len(citations)
    
    citations.sort()
    
    for i in range(n):
        if citations[i] >= n-i:
            return n-i
    return 0