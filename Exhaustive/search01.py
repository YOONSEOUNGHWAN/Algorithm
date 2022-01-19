# 모의고사
def solution(answers):
    answer = [0, 0, 0]
    # 1 2 3 4 5
    # 2 1 2 3 2 4 2 5
    # 3 3 1 1 2 2 4 4 5 5
    st1 = [1,2,3,4,5]
    st2 = [2,1,2,3,2,4,2,5]
    st3 = [3,3,1,1,2,2,4,4,5,5]
    for i in range(len(answers)):
        if(answers[i] == st1[i%len(st1)]):
            answer[0]+=1
        if(answers[i] == st2[i%len(st2)]):
            answer[1]+=1
        if(answers[i] == st3[i%len(st3)]):
            answer[2]+=1
    
    ret = sorted(enumerate(answer), key = lambda x:(-x[1],x[0]))
    print(ret)
    max = ret[0][1]
    find = []
    for i in ret:
        if(i[1] == max):
            find.append(i[0]+1)
    return find