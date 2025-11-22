package online.niyv0708.service;

import online.niyv0708.pojo.PageResult;
import online.niyv0708.pojo.Student;
import online.niyv0708.pojo.StudentQueryParam;

import java.util.List;

public interface StudentService {
    PageResult<Student> page(StudentQueryParam studentQueryParam);

    void delete(List<Integer> ids);

    void save(Student student);

    Student getInfo(Integer id);

    void update(Student student);

    void updateViolation(Integer id, Integer score);
}
