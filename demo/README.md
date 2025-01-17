


# README
Ассалаумаалейкум 
Мое тест зд

# Описание проекта
Тут проект с круд операциями с майскл и спринг 
**Возможности**:

- Создание пользователя (POST)
- Получение списка всех пользователей (GET)
- Получение пользователя по ID (GET)
- Обновление пользователя (PUT)
- Удаление пользователя (DELETE)
подробнее можно посмотреть в контроллере src\main\java\com\example\demo\controller\UserController.java

# Структура

  - `entity/User.java` — сущность пользователя.
  - `repository/UserRepository.java` — интерфейс JpaRepository для работы с БД.
  - `service/UserService.java` — бизнес-логика CRUD.
  - `controller/UserController.java` — REST-контроллер с эндпоинтами `/api/users`.


# Подготовка окружения

1. **Установить Docker** (Docker Desktop для Windows / Mac или Docker Engine для Linux).
https://www.docker.com/get-started/ вот тут можно скчать потом обязательно надо перезагрузить систему для обновление path 
---

## Запуск в Docker

1. Откройте терминал (PowerShell / CMD / Bash) в корне проекта (там, где лежат `docker-compose.yml` и `Dockerfile`). тут это папка DEMO
2. Выполните:
   docker-compose up --build
   чем быстрее инте тем лучше
   в консоли надо будет посмотреть не вылезло ли ошибок изза конфликтов версий и тд 
3. Теперь проет доступен по адрессу:
   http://localhost:8080
   можно поменять порт в докер файле как тебе удобно 
    (docker-compose down) что 

# 1. Создание пользователя (POST)
на винде лучше через повер шел Invoke-RestMethod так как curl может выдавать ошибки если не правильно скачан 


в консоли или в повершеле
Invoke-RestMethod -Method Post `
  -Uri "http://localhost:8080/api/users" `
  -ContentType "application/json" `
  -Body '{"name":"Aisultan","email":"Aisultan.Yerlanuly@nitec.kz"}'


curl -X POST -H "Content-Type: application/json" \
  -d '{"name":"Aisultan","email":"Aisultan.Yerlanuly@nitec.kz"}' \
  http://localhost:8080/api/users



# 2. Получение списка всех пользователей (GET)

  Invoke-RestMethod -Method Get -Uri "http://localhost:8080/api/users"
 
  curl http://localhost:8080/api/users
 

# 3. Получение пользователя по ID (GET)
  Invoke-RestMethod -Method Get -Uri "http://localhost:8080/api/users/1"

  curl http://localhost:8080/api/users/1


Если пользователя с id=1 нет, вернётся `404 Not Found`.

# 4. Обновление пользователя (PUT)

Если хоттим поменять `name` и `email` у пользователя, скажем с id=2 ну или посмотреть в списке юзеров .

  Invoke-RestMethod -Method Put `
    -Uri "http://localhost:8080/api/users/2" `
    -ContentType "application/json" `
    -Body '{"name":"Aliar","email":"Aliar.Azimzham@nitec.kz"}'

 
  curl -X PUT -H "Content-Type: application/json" \
    -d '{"name":"Aliar","email":"Aliar.Azimzham@nitec.kz"}' \
    http://localhost:8080/api/users/2

тут в  http://localhost:8080/api/users/2 в последняя цифра это и есть id юзера который можно посмотреть в списке юзеров 
# 5. Удаление пользователя (DELETE)

  Invoke-RestMethod -Method Delete -Uri "http://localhost:8080/api/users/2"

  curl -X DELETE http://localhost:8080/api/users/2
тут тоже самое что и выше 



