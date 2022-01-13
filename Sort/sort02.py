# 가장 큰 수
def solution(numbers):
    answer = ''
    number = []
    number = list(map(str,numbers))
    print(number)
    dic={}
    for i in number:
        dic[i] = len(i)
    print(dic)
    dic = sorted(dic.items(), key = lambda x: (-x[1],x[0]), reverse = True)
    print(dic)
    for i in dic:
        answer+=i[0]
    return answer