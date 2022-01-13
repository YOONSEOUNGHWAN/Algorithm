# 기능 개발
def solution(progresses, speeds):
    answer = []
    progresses.reverse()
    speeds.reverse()
    time = []
    progresses
    for i in progresses:
        time.append(100-i)
    # print(time)
    left = list(i-j for i, j in zip(time, speeds))
    while(left):
        cnt = 0
        find = 0
        while(1):
            if(len(left)==0):
                break
            find = left.pop()
            if(find > 0):
                left.append(find)
                break
            cnt+=1
        if(cnt!=0):
            answer.append(cnt)
        left = list(i-j for i, j in zip(left, speeds))
    
    return answer