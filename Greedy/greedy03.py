def solution(numbers, k):
    stack=[]
    answer = 0
    for num in numbers:
        while(stack and stack[-1] < num and k>0):
            stack.pop()
            k-=1
            #print(stack)
        stack.append(num)
    #예외 54321 / 2 -> 543 출력
    answer = ''.join(stack)[:len(numbers)-k]
    return answer


# def solution(numbers, k):
#     answer = 0
#     list(numbers)
#     for _ in range(k):
#         numbers.remove(min(numbers))
#     answer = ''.join(numbers)
#     return answer








# def solution(numbers, k):
#     answer = 0
#     n = len(numbers)
#     select = n - k
#     for i in range(1<<n):
#         if(bin(i).count('1')!=select):
#             continue
#         num = []
#         for j in range(n):
#             if(i & 1 << j):
#                 num.append(numbers[j])
#         max = int(''.join(num))
#         if(max > answer):
#             answer = max

#     return str(answer)




# 큰 수  만들기
import math
import itertools
# "12345" [1,2,3,4,5] 
def solution(numbers, k):
    answer = []
    n = len(numbers)-k
    List = list(itertools.combinations(numbers,n))
    for i in List:
        num = int(''.join(list(i)))
        answer.append(num)
    find = str(max(answer))
    return find