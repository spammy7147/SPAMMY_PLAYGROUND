##반복문 + 메모제이션
print('##fn_forLoop##')
def fn_forLoop(n):
    arr = [-1] * (n + 2)
    print(arr)
    arr[0] = 0
    arr[1] = 1

    for i in range(2, n + 1):
        arr[i] = arr[i-1] + arr[i-2]
    print(arr[n])

fn_forLoop(10)


##재귀함수
print('##fn_fibo##')
def fn_fibo(n):
    global cnt1
    cnt1 += 1

    if n == 0:
        return 0
    if n == 1:
        return 1
    return fn_fibo(n-2) + fn_fibo(n-1)

cnt1 = 0
print(fn_fibo(10))
print(cnt1)

##재귀함수 + 메모이제이션
print('##fn_fibo_memo##')
def fn_fibo_memo(n):
    global arr, cnt2
    cnt2 += 1
    #base case 
    if arr[n] != -1:
        return arr[n]
    arr[n] = fn_fibo_memo(n-1) + fn_fibo_memo(n-2) 

    # n=2       fn_fibo_memo(n-2) = 0(arr[0]) | fn_fibo_memo(n-1) = 1(arr[1]) | arr[2] = 0 + 1 
    # n=3       fn_fibo_memo(n-2) = 1 | fn_fibo_memo(n-1) = 1 | arr[3] = 1 + 1
    # n=4       fn_fibo_memo(n-2) = 1 | fn_fibo_memo(n-1) = 2 | arr[3] = 1 + 2
    print(arr)
    return arr[n]

cnt2 = 0
arr = [-1] * (5 + 1)
print('초기화')
print(arr)
arr[0] = 0
arr[1] = 1
print(fn_fibo_memo(5))
print(cnt2)

