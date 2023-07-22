import sys
finger = int(sys.stdin.readline())
available_count = int(sys.stdin.readline())

hand = [[8, 8], [6, 2], [4, 4], [2, 6], [8, 8]]
count = 0

count = finger - 1
if available_count != 0:
    if available_count % 2 == 1:
        count += hand[finger - 1][0] * (available_count // 2 + 1) + hand[finger - 1][1] * ((available_count - 1) // 2)
    else:
        count += hand[finger - 1][0] * (available_count // 2) + hand[finger - 1][1] * ((available_count -1) // 2 + 1)
print(int(count))

