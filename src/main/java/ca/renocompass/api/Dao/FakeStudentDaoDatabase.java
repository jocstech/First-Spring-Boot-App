package ca.renocompass.api.Dao;

import ca.renocompass.api.Entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("fakeData")
public class FakeStudentDaoDatabase implements StudentDao {

    private static Map<Integer, Student> students;

    static {

        students = new HashMap<Integer, Student>() {

            {
                put(1, new Student(1, "Said", "Computer Science"));
                put(2, new Student(2, "Joseph", "French Study"));
                put(3, new Student(3, "Ted", "Mathematics"));
                put(4, new Student(4, "Vincent", "Marketing"));
            }
        };
    }

    @Override
    public Collection<Student> getAllStudents(){
        return this.students.values();
    }

    @Override
    public Student getStudentById(int id){
        return this.students.get(id);
    }

    @Override
    public void removeStudentById(int id) {
        this.students.remove(id);
    }

    @Override
    public void updateStudent(Student student) {
        students.put(student.getId(), student);
    }

    @Override
    public void createStudent(Student student) {
        Student newStudent = new Student(this.students.size()+1, student.getName(), student.getCourse());
        this.students.put(newStudent.getId(), newStudent);
    }
}
