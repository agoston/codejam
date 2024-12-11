#!/bin/env python

from codecs import encode
from collections import *
from functools import *
import re
from bisect import *




# with open('dino.in.txt', encoding="utf-8") as f:
#     read_data = f.read()

# a1 = 0
# a2 = len(read_data)-1
# c=0

# while a1 < a2:
#    if read_data[a1] != read_data[a2]:
#       c+=1
#    a1+=1
#    a2-=1

# print(c)

with open('tornasor.in.txt', encoding="utf-8") as f:
    read_data = f.read()


height = [int(x) for x in read_data.splitlines()]

# sorted = sorted(height)
# or
sorted = height.copy()
sorted.sort()
# print(height)
# print(sorted)
count = 0
# for x in range(0, len(sorted)):
#    if (height[x] == sorted[x]):
#       count+=1

for x,y in zip(height, sorted):
    if x == y:
        count += 1

# all(n > 0 for n in read_data)
# any(n > 0 for n in read_data)

print(count)
# print(bisect_left(height, 134))

# counts = defaultdict(lambda: 0)

# for c in read_data:
#    counts[c] += 1
      
# print(counts)

# dict2 = {x:dict1[x] for x in keys}

# print(f"---\nCT:{read_data.count('CT')}")

# a_count = sum(map(lambda x: 1 if 'A' in x else 0, read_data))
# print(f'A: {a_count}')

# t_count = reduce(lambda acc, c: acc + 1 if c == 'T' else acc, read_data, 0)
# print(f"T: {t_count}")

# g_count = len(re.findall("G", read_data))
# print(f"E: {g_count}")

# byte_array = [x.encode('ascii')[0]-'A'.encode('ascii')[0] for x in read_data]
# byte_array.sort(key = lambda x: 1000-x)
# print(byte_array)

# valid = [0 for _ in range(c + 1)]