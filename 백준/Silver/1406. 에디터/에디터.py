import sys
from collections import deque
Left_list = deque(list(sys.stdin.readline().strip()))
Right_list = deque()
n = int(sys.stdin.readline())
for _ in range(n):
    command = sys.stdin.readline().split()
    if command[0] == "L":
        if Left_list:
            Right_list.appendleft(Left_list.pop())
    elif command[0] == "D":
        if Right_list:
            Left_list.append(Right_list.popleft())
    elif command[0] == "B":
        if Left_list:
            Left_list.pop()
    elif command[0] == "P":
            Left_list.append(command[1])
            
print("".join(Left_list + Right_list))