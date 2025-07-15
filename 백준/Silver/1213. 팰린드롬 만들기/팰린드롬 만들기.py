s = input()
num = [0] * 26
ans = ""
for c in s:
    num[ord(c)-ord("A")] += 1
temp = ""
cnt = 0
for idx,nums in enumerate(num):
    if nums != 0 and nums % 2 == 0:      
        for _ in range((nums) // 2):
            ans += chr(idx+ord("A"))  
    elif nums != 0 and nums % 2 == 1:
        cnt += 1      
        for _ in range(nums // 2):
            ans += chr(idx+ord("A")) 
        temp = chr(idx+ord("A"))  
if temp != "" and cnt < 2:
    print(ans + temp + ans[::-1])
elif temp == "" and cnt < 2:
    print(ans+ans[::-1])
elif cnt >=2:
    print("I'm Sorry Hansoo")