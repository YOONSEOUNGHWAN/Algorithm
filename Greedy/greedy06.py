#단속 카메라.
def solution(routes):
    routes.sort(key = lambda x:x[0])
    answer = 1
    end = routes[0][1]
    [-----------------------]
    [-----]
        [--------]
          c<-카메라 설치
          [-----------]
                 c<-카메라 설치
                         [--]
                            c<-카메라 설치
    for i in range(1,len(routes)):
        if routes[i][0] <= end:
            end = min(routes[i][1], end)
        else:
            end = routes[i][1]
            answer+=1
            
    return answer









#단속 카메라
def solution(routes):
    routes.sort(key = lambda x:x[1])
    answer = 1
    pivot = routes[0][1]
    
    for i in range(1,len(routes)):
        #설치한 위치에 다음 차량이 들어오지 않았다면 재설치
        if pivot < routes[i][0]:
            pivot = routes[i][1]
            answer+=1
    
    return answer