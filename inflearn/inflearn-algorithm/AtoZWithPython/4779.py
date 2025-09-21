print('##bottom_up##')
def bottom_up(x):
    ans = ['' for _ in range(13)]
    ans[0] = '-'

    print('초기값')
    print(ans)

    for i in range(1, 13):
        print('i = ' + str(i))
        ans[i] = ans[i-1] + (' ' * (3 ** (i-1))) + ans[i-1]
        if i < 6:  
            print(ans[i])

    print(ans[x])
   
# bottom_up(6)

print('##재귀함수##')
def func(k):
	# base case
	if k == 0:
		return '-'

	# recursive case
	return func(k-1) + (' ' * (3 ** (k-1))) + func(k-1)

print(func(6))