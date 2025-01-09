def find_max_occurred_alphabet(string):
    arr = find_max_occurred_array(string)
    cnt = 0;
    max_num = 0;
    max_cnt = 0;
    for alphabet in arr:
        if alphabet > max_num:
            max_num = alphabet
            max_cnt = cnt
        cnt += 1

    return chr(max_cnt + ord('a'))

def find_max_occurred_array(string):
    arr = [0] * 26
    for char in string:
        if not char.isalpha():
            continue
        arr[ord(char) - ord('a')] += 1
    return arr


print("정답 = i 현재 풀이 값 =", find_max_occurred_alphabet("hello my name is dingcodingco"))
print("정답 = e 현재 풀이 값 =", find_max_occurred_alphabet("we love algorithm"))
print("정답 = b 현재 풀이 값 =", find_max_occurred_alphabet("best of best youtube"))