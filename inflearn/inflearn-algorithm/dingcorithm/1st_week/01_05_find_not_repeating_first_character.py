input = "abadabac"

def find_not_repeating_first_character(string):
    arr = find_max_occurred_array(string)
    not_repeat_array = []
    for idx in range(len(arr)):
       if arr[idx] == 1:
           not_repeat_array.append(chr(idx + ord('a')))

    for char in string:
        if char in not_repeat_array:
            return char
    return "_"

def find_max_occurred_array(string):
    arr = [0] * 26
    for char in string:
        if not char.isalpha():
            continue
        arr[ord(char) - ord('a')] += 1
    return arr



result = find_not_repeating_first_character
print("정답 = d 현재 풀이 값 =", result("abadabac"))
print("정답 = c 현재 풀이 값 =", result("aabbcddd"))
print("정답 =_ 현재 풀이 값 =", result("aaaaaaaa"))