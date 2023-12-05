# -*- coding: utf-8 -*-

import requests


"""
Тестирование post (добавление)
"""
LOCALE="" # Варианты en, rus, ces



if __name__ == "__main__":
    new_patien = {'id': 22837, 'temp': 368, 'pathogen': 'бактерия', 'cause': 'ОРЗ, травма', 'symptoms': 'слизистое отделяемое', 'kind': 1, 'course': 2, 'complications': ''}
    headers={"Accept-Language": LOCALE}

    TESTED_ID = 34
    r = requests.get(f"http://127.0.0.1:8080/hospital/pinkeye/{TESTED_ID}", headers=headers)
    print(f"Patient with id={TESTED_ID}: \"{r.json()}\"")

    r = requests.post(f"http://127.0.0.1:8080/hospital/pinkeye/{TESTED_ID}", json=new_patien, headers=headers)
    print(f"Failed answer: \"{r.content.decode('utf-8')}\"")



    print()
    TESTED_ID = 22837

    r = requests.get(f"http://127.0.0.1:8080/hospital/pinkeye/{TESTED_ID}", headers=headers)
    print(f"Before: \"{r.content.decode('utf-8')}\", status={r.status_code}")

    r = requests.post(f"http://127.0.0.1:8080/hospital/pinkeye/{TESTED_ID}", json=new_patien, headers=headers)
    print(f"Answer: \"{r.content.decode('utf-8')}\"")

    r = requests.get(f"http://127.0.0.1:8080/hospital/pinkeye/{TESTED_ID}", headers=headers)
    print(f"After: \"{r.json()}\"")

