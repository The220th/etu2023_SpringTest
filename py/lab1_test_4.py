# -*- coding: utf-8 -*-

import requests


"""
Тестирование delete (удаление)
"""


if __name__ == "__main__":

    TESTED_ID = 22813

    r = requests.get(f"http://127.0.0.1:8080/hospital/pinkeye/{TESTED_ID}")
    print(f"No such patient answer: \"{r.content}\", status={r.status_code}")

    r = requests.delete(f"http://127.0.0.1:8080/hospital/pinkeye/{TESTED_ID}")
    print(f"Failed answer: \"{r.content}\"")



    print()
    TESTED_ID = 34

    r = requests.get(f"http://127.0.0.1:8080/hospital/pinkeye/{TESTED_ID}")
    print(f"Before: \"{r.json()}\"")

    r = requests.delete(f"http://127.0.0.1:8080/hospital/pinkeye/{TESTED_ID}")
    print(f"Answer: \"{r.content}\"")

    r = requests.get(f"http://127.0.0.1:8080/hospital/pinkeye/{TESTED_ID}")
    print(f"After: \"{r.content}\", status={r.status_code}")

