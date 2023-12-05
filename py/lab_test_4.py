# -*- coding: utf-8 -*-

import requests


"""
Тестирование delete (удаление)
"""
LOCALE="" # Варианты en, rus, ces



if __name__ == "__main__":
    headers={"Accept-Language": LOCALE}

    TESTED_ID = 22813

    r = requests.get(f"http://127.0.0.1:8080/hospital/pinkeye/{TESTED_ID}", headers=headers)
    print(f"No such patient answer: \"{r.content.decode('utf-8')}\", status={r.status_code}")

    r = requests.delete(f"http://127.0.0.1:8080/hospital/pinkeye/{TESTED_ID}", headers=headers)
    print(f"Failed answer: \"{r.content.decode('utf-8')}\"")



    print()
    TESTED_ID = 34

    r = requests.get(f"http://127.0.0.1:8080/hospital/pinkeye/{TESTED_ID}", headers=headers)
    print(f"Before: \"{r.json()}\"")

    r = requests.delete(f"http://127.0.0.1:8080/hospital/pinkeye/{TESTED_ID}", headers=headers)
    print(f"Answer: \"{r.content.decode('utf-8')}\"")

    r = requests.get(f"http://127.0.0.1:8080/hospital/pinkeye/{TESTED_ID}", headers=headers)
    print(f"After: \"{r.content.decode('utf-8')}\", status={r.status_code}")

