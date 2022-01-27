# 카펫
def Pair(n):
    ret = []
    for i in range(1,n+1):
        if(n%i==0):
            ret.append([n//i,i])
    return ret


def solution(brown, yellow):
    total = brown + yellow
    for pair in Pair(total):
        if(pair[0]+pair[1] == brown/2 + 2 and pair[0]*pair[1] == total):
            return pair
    return -1