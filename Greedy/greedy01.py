# 체육복
def solution(n, lost, reserve):
    Reserve = [i for i in reserve if i not in lost]
    # print(reserve)
    Lost = [i for i in lost if i not in reserve]
    Lost.sort()
    for i in Lost:
        if i-1 in Reserve:
            Reserve.remove(i-1)
        elif i+1 in Reserve:
            Reserve.remove(i+1)
        else:
            n-=1
    answer = n 
    return answer