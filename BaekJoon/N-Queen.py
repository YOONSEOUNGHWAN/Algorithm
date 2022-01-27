import copy

answer = 0

def check(Board):
    cnt=0
    for i in range(N):
        for j in range(M):
            if(Board[i][j] == 0):
                cnt+=1

    return cnt

#얕은복사....
def fill(Board):
    global answer
    clone = copy.deepcopy(Board)
    visited = [[False for _ in range(M)] for _ in range(N)]
    stack = []
    for r in range(N):
        for c in range(M):
            if(clone[r][c] == 2):
                stack.append((r,c))
               
    while(stack):
        curr = stack.pop()
        if visited[curr[0]][curr[1]]: continue

        visited[curr[0]][curr[1]] = True
        clone[curr[0]][curr[1]] = 2

        for i in range(4):
            nr = curr[0] + D[i][0]
            nc = curr[1] + D[i][1]
            if(nr < 0 or nr > N-1 or nc < 0 or nc > M-1): continue
            if visited[nr][nc]: continue
            if(clone[nr][nc] == 1): continue
            stack.append((nr,nc))

    # for i in range(N):
    #     for j in range(M):
    #         print(clone[i][j], end=' ')
    #     print()
    
    # print()
    answer = max(answer, check(clone))
    
        
        
# 인터넷 참조.
def block(i):
    # 벽을 세웠다면,,
    if i == 3:
        fill(Board)
        return
    
    for x in range(N):
        for y in range(M):
            if(Board[x][y] == 0):
                Board[x][y] = 1
                block(i+1)

                Board[x][y] = 0



# if __name__ == '__main__':
    # 상 하 좌 우
D = ((-1,0), (1,0), (0,-1),(0,1))
N,M = map(int, input().split())
Board = [list(map(int, input().split())) for _ in range(N)] 
block(0)
print(answer)
   