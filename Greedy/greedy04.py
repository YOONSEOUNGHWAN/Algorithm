#구멍보트
def solution(people, limit):
    answer = 0
    left = 0
    right = len(people)-1
    people.sort()
    while(left<right):
        sum = people[left] + people[right]
        if(sum > limit):
            right-=1
        else:
            people[left] = 0
            people[right] = 0
            answer += 1
            left+=1
            right-=1
    for i in people:
        if(i!= 0):
            answer+=1
    return answer
