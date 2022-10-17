import random
print(30 % 60)
num = random.randrange(0, 31)

lineNum = 0
with open('wordList.txt') as f:
    while True:
        line = f.readline()
        lineNum = lineNum + 1
        if not line:
            break
        print(line.strip())


