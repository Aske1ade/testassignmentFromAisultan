# 1) Используем официальный образ Maven для сборки
FROM maven:3.8.5-openjdk-17 AS builder

# Укажем рабочую директорию внутри контейнера
WORKDIR /app

# 2) Сначала копируем pom.xml и скачиваем зависимости для кеширования
COPY pom.xml .
RUN mvn dependency:go-offline -B

# 3) Копируем исходники и собираем
COPY src ./src
RUN mvn clean package -DskipTests

# 4) Запускаем готовый JAR в runtime-образе
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=builder /app/target/demo-0.0.1-SNAPSHOT.jar app.jar

# Открываем порт 8080
EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]
