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

# def solution(clothes):
#     dic = {}
#     for wear in clothes:
#         if(wear[1] not in dic):
#             dic[wear[1]] = 1
#         else:
#             dic[wear[1]] += 1
    
#     wear = list(dic.keys())
#     num = len(wear)
#     answer = 0

#     for n in range(1,num+1):
#         for i in range(1<<num):
#             if(bin(i).count('1'!=n)):
#                 continue
#             sum = 1
#             for j in range(num):
#                 if(i & 1 << j):
#                     sum *= dic[wear[j]]
#                 answer += sum
#     return answer


# from import combinations

# def solution(clothes):
#     dic = {}
#     for wear in clothes:
#         if(wear[1] not in dic):
#             dic[wear[1]] = 1
#         else:
#             dic[wear[1]] += 1
    
#     wear = list(dic.keys())
#     num = len(wear)
#     answer = 0

#     for i in range(1,num+1):
#         c = combinations(wear,i)
#         for c_set in c:
#             sum = 1
#             for a in c_set:
#                 sum *= dic[a]
#             answer += sum
#     return answer