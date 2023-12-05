# -*- coding: utf-8 -*-

import requests


"""
Тестирование post (добавление)
"""


if __name__ == "__main__":

    new_patien = {'id': 22837, 'temp': 368, 'pathogen': 'бактерия', 'cause': 'ОРЗ, травма', 'symptoms': 'слизистое отделяемое', 'kind': 1, 'course': 2, 'complications': ''}

    TESTED_ID = 34
    r = requests.get(f"http://127.0.0.1:8080/hospital/pinkeye/{TESTED_ID}")
    print(f"Patient with id={TESTED_ID}: \"{r.json()}\"")

    r = requests.post(f"http://127.0.0.1:8080/hospital/pinkeye/{TESTED_ID}", json=new_patien)
    print(f"Failed answer: \"{r.content}\"")



    print()
    TESTED_ID = 22837

    r = requests.get(f"http://127.0.0.1:8080/hospital/pinkeye/{TESTED_ID}")
    print(f"Before: \"{r.content}\", status={r.status_code}")

    r = requests.post(f"http://127.0.0.1:8080/hospital/pinkeye/{TESTED_ID}", json=new_patien)
    print(f"Answer: \"{r.content}\"")

    r = requests.get(f"http://127.0.0.1:8080/hospital/pinkeye/{TESTED_ID}")
    print(f"After: \"{r.json()}\"")

