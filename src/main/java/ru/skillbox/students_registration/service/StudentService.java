package ru.skillbox.students_registration.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import ru.skillbox.students_registration.event.CreateStudentEvent;
import ru.skillbox.students_registration.event.DeleteStudentEvent;
import ru.skillbox.students_registration.model.Student;


import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final ApplicationEventPublisher eventPublisher;
    private final Map<Integer, Student> students = new HashMap<>();

    public Student getStudent(int id) {
        return students.get(id);
    }

    public Map<Integer, Student> getAllStudents() {
        return students;
    }

    public void clearStudents() {
        students.clear();
    }

    public void addStudent(Student student) {
        students.put(student.getId(), student);
        eventPublisher.publishEvent(new CreateStudentEvent(this, student));
    }

    public void deleteStudent(int id) {
        students.remove(id);
        eventPublisher.publishEvent(new DeleteStudentEvent(this, id));
    }
}