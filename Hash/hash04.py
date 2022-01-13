# 베스트 앨범
def solution(genres, plays):
    answer = []
    dic = {}
    for i in range(len(genres)):
        if genres[i] not in dic:
            dic[genres[i]] = [[i],plays[i]]
        else:
            dic[genres[i]][0].append(i)
            dic[genres[i]][1] += plays[i]
            
    for genre in dic.keys():
        dic[genre][0].sort(key = lambda x:-plays[x])
    print(dic)
    
    dic = sorted(dic.items(), key = lambda x: -x[1][1])
    print(dic)
    for i in dic:
        if(len(i[1][0])==1):
            answer.extend(i[1][0])
        else:
            answer.extend(i[1][0][:2])
    return answer