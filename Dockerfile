# Используем официальный образ OpenJDK 17
FROM openjdk:17-jdk-slim
# Устанавливаем переменную окружения JAVA_HOME
ENV JAVA_HOME /opt/java/openjdk

# Устанавливаем рабочую директорию для приложения
WORKDIR /app

# Копируем JAR файл приложения в контейнер
COPY target/students-registration-0.0.1-SNAPSHOT.jar /app/app.jar

# Команда для запуска приложения
CMD ["java", "-jar", "app.jar"]