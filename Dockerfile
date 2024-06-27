# Используем официальный образ OpenJDK 17
<<<<<<< HEAD
FROM openjdk:17-jdk-slim
=======
FROM adoptopenjdk/openjdk17:alpine-jre
>>>>>>> d43000573e9d48baae3eec333b5e411b3f33e673

# Устанавливаем переменную окружения JAVA_HOME
ENV JAVA_HOME /opt/java/openjdk

# Устанавливаем рабочую директорию для приложения
WORKDIR /app

# Копируем JAR файл приложения в контейнер
COPY target/students-registration-0.0.1-SNAPSHOT.jar /app/app.jar

# Команда для запуска приложения
CMD ["java", "-jar", "app.jar"]