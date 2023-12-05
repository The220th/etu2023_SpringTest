# -*- coding: utf-8 -*-

import requests


"""
Тестирование put (модификация)
"""


if __name__ == "__main__":

    new_patien = {'id': 34, 'temp': 368, 'pathogen': 'бактерия', 'cause': 'ОРЗ, травма', 'symptoms': 'слизистое отделяемое', 'kind': 1, 'course': 2, 'complications': ''}

    TESTED_ID = 22838

    r = requests.get(f"http://127.0.0.1:8080/hospital/pinkeye/{TESTED_ID}")
    print(f"No such patient answer: \"{r.content}\", status={r.status_code}")

    r = requests.put(f"http://127.0.0.1:8080/hospital/pinkeye/{TESTED_ID}", json=new_patien)
    print(f"Failed answer: \"{r.content}\"")



    print()
    TESTED_ID = 34

    r = requests.get(f"http://127.0.0.1:8080/hospital/pinkeye/{TESTED_ID}")
    print(f"Before: \"{r.json()}\"")

    r = requests.put(f"http://127.0.0.1:8080/hospital/pinkeye/{TESTED_ID}", json=new_patien)
    print(f"Answer: \"{r.content}\"")

    r = requests.get(f"http://127.0.0.1:8080/hospital/pinkeye/{TESTED_ID}")
    print(f"After: \"{r.json()}\"")

