# -*- coding: utf-8 -*-

import requests


for i in range(1, 5051+1):
    r = requests.get(f"http://127.0.0.1:8080/hospital/pinkeye/{i}")
    j = r.json()
    print(j)
    input()

# print(d)
