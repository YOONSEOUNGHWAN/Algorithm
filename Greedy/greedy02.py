import math
import itertools

def isPrime(n):
    if(n==0 or n==1):
        return False
    
    for i in range(2,int(math.sqrt(n))+1):
        if n % i == 0:
            return False
        
    return True

def solution(numbers):
    answer = 0
    for i in range(1, len(numbers)+1):
        List = list(itertools.permutations(numbers,i))
        print(List)
        
    return answer