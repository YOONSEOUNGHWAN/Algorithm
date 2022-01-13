# 완주하지 못한 선수
def solution(participant, completion):
    participant.sort()
    completion.sort()
    num = len(completion)
    for i in range(num):
        if(participant[i] != completion[i]):
            return participant[i]
    answer = participant[num]
    return answer