#!/bin/env python

from codecs import encode
from collections import *
from functools import *
import re
from bisect import *


with open('cikkek.teszt.in.txt', encoding="utf-8") as f:
    read_data = f.read()

cikk = set()
refs = set()

for line in read_data.split('\n'):
    elems = line.split()
    if (len(elems) == 0):
        continue
    cikk.add(elems[0])
    for ref in elems[1:]:
        refs.add(ref)

count=0
for x in cikk:
    if x in refs:
        count += 1

print(count)

# seen |= set(cikkek)     # - | & ^


# with open('kerek.in.txt', encoding="utf-8") as f:
#     read_data = f.read()

# x=[]
# for i in read_data.split():
#     x.append(int(i))

# count = 0
# for i in x:
#     if i % 5 == 1 or i % 5 == 4:
#         count += 1

# print(count)





# height = [int(x) for x in read_data.splitlines()]

# sorted = sorted(height)
# or
# sorted = height.copy()
# sorted.sort()
# print(height)
# print(sorted)

# count = 0
# for x in range(0, len(sorted)):
#    if (height[x] == sorted[x]):
#       count+=1

# for x,y in zip(height, sorted):
#     if x == y:
#         count += 1

# all(n > 0 for n in read_data)
# any(n > 0 for n in read_data)

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

# queue = deque(["Eric", "John", "Michael"])
# queue.append("Terry")           # Terry arrives
# queue.append("Graham")          # Graham arrives
# queue.popleft()                 # The first to arrive now leaves

# del a[0]
# del a[2:4]
