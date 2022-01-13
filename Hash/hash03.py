# 위장
from itertools import combinations

def solution(clothes):
    dic = {}
    for wear in clothes:
        if(wear[1] not in dic):
            dic[wear[1]] = 2
        else:
            dic[wear[1]] += 1
    answer = 1
    for val in dic.values():
        answer*=val
    answer-=1
    return answer