##Запуск проекта

Для запуска потребуется установленный docker-compose

1. Клонировать репозиторий
```bash
$ git pull https://github.com/silenseram/jint
```
3. В директории с проектом выполнить:
```bash
$ docker-compose up
```

##API

###Пост лога

```bash
$ curl -XPOST localhost:6007/logs/ -d '{"content": "LOG_CONTENT"}' -H "Content-Type: application/json" -v
```
где LOG_CONTENT - содержимое лога


Поиск по логам: 
```bash
$ curl localhost:6007/logs/?from=2022-03-24&to=2022-03-25 -v
```
Параметры from & to - необязательные.
from по дефолту - вчера, to - сейчас.