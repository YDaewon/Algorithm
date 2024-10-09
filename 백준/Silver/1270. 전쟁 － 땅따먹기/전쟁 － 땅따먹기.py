import collections

N = int(input())
result = []
for _ in range(N):
    ground_num_i = input().split()  # 땅번호 1번부터
    ground = int(ground_num_i[0])
    del ground_num_i[0]
    count_num_i = collections.Counter(ground_num_i).items()
    result_text = 0
    result_num = 0
    for w, i in list(count_num_i):
        if(ground / 2) < i:
            if i > result_num:
                result_text = w
                result_num = i

    if result_num > ground / 2:
        result.append(result_text)
    else:
        result.append("SYJKGW")

for i in result:
    print(i)
