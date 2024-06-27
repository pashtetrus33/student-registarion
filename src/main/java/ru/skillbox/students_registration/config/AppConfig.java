package ru.skillbox.students_registration.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.skillbox.students_registration.model.Student;
import ru.skillbox.students_registration.service.StudentService;

@Slf4j
@Configuration
public class AppConfig {

    @Value("${app.create-mock-data:false}")
    private boolean createMockData;

    @Bean
    public ApplicationRunner mockData(StudentService studentService) {
        if (createMockData) {
            log.info("Creating mock data");
            studentService.addStudent(new Student("Ivan", "Ivanov", 33));
            studentService.addStudent(new Student("Pavel", "Bakanov", 40));
            studentService.addStudent(new Student("Mariia", "Semina", 25));
        }
        //По другому не получилось реализовать (в случае возвращения args не инициализируются данные)
        return null;
    }
}