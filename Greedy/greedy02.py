# 조이스틱
def solution(name):
    answer = 0
    move = len(name)-1
    for i, ch in enumerate(name):
        answer += min(ord(ch) - ord('A'), ord('Z') - ord(ch) + 1)
        # x x A A A x 
        next = i+1
        while(next < len(name) and name[next] == 'A'):
            next += 1
        move = min(move, i+i+len(name)-next)
    answer += move
    return answer