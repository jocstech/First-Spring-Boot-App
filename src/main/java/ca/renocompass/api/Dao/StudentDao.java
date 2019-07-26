package ca.renocompass.api.Dao;

import ca.renocompass.api.Entity.Student;

import java.util.Collection;

public interface StudentDao {
    Collection<Student> getAllStudents();

    Student getStudentById(int id);

    void removeStudentById(int id);

    void updateStudent(Student student);

    void createStudent(Student student);
}
