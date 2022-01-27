def checkNum(x):
    a = [0 for _ in range(10)]
    idx = 0

    while(x):
        a[idx] = x % 10
        x//=10
        idx += 1

    for i in range(idx-2):
        if(a[i] - a[i+1] != a[i+1] - a[i+2]): return False
    return True

n = int(input())
cnt = 0
for num in range(1, n+1):
    if(checkNum(num)): 
        cnt+=1
print(cnt)
