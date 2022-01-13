# K번째 수
def solution(array, commands):
    answer = []
    #파이썬이라 쉬운듯..
    for i in commands:
        tmp = array[i[0] -1 : i[1]]
        tmp.sort()
        answer.append(tmp[i[2]-1])
    return answer