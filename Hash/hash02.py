# 전화번호 목록
def solution(phone_book):
    phone_book.sort()
    num = len(phone_book)
    for i in range(num-1):
        if(phone_book[i+1].startswith(phone_book[i])):
            return False
    answer = True
    return answer