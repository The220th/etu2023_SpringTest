# etu2023_SpringTest

Разработка приложений в распределенной среде

# Необходимые пакеты

``` bash
yay jdk-openjdk # java хотя бы 17
archlinux-java get # get current verison
archlinux-java status # list of available verison
sudo archlinux-java set java-17-openjdk # set the required verison, such as java-17-openjdk

yay maven

yay intellij-idea-community-edition

yay postman-bin
```

# Инициализация шаблона

https://start.spring.io/

![](./imgs/spring_start.png)

# Необходимые плагины

Нужно установить в `IntelliJ` плагин `Lombok`.

# Запуск приложения

Зайти на адрес `http://127.0.0.1:8080/hospital/pinkeye/{patient_id}`

# Демонстрация

Для тестирования нужен пакет `requests`:

``` bash
pip3 install requests
```

## Тестирование первой работы

В директории `py` лежат скрипты:

- `lab_test_1.py`

- `lab_test_2.py`

- `lab_test_3.py`

- `lab_test_4.py`

## Тестирование второй работы (1)

В директории `py` лежат скрипты, но нужно менять переменную LOCALE:

- `lab_test_1.py`

- `lab_test_2.py`

- `lab_test_3.py`

- `lab_test_4.py`

# Тестирование второй работы (2)

В директории `py` лежит скрипт `lab_test_2.py`. Нужно менять переменную LOCALE.

## Тестирование второй работы (3)

Переходить по ссылкам

- http://127.0.0.1:8080/actuator

- http://127.0.0.1:8080/actuator/health

- http://127.0.0.1:8080/actuator/info

- http://localhost:8080/actuator/beans (данные о bean-компонентах приложения)

- http://localhost:8080/actuator/env (данные об окружении)

- http://localhost:8080/actuator/metrics (все метрики)

- http://localhost:8080/actuator/metrics/application.started.time (метрика: время для запуска приложения)

- http://localhost:8080/actuator/metrics/http.server.requests (метрика: длительность обработки запроса HTTP-сервером)

- http://localhost:8080/actuator/metrics/system.cpu.count (метрика: число доступных процессоров для JVM)

