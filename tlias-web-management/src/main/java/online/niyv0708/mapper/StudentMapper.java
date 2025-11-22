package online.niyv0708.mapper;


import online.niyv0708.pojo.Student;
import online.niyv0708.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {

    List<Student> list(StudentQueryParam studentQueryParam);

    void delete(List<Integer> ids);

    void insert(Student student);

    @Select("select id, name, no, gender, phone, id_card, is_college, address, degree, graduation_date, clazz_id, violation_count, violation_score, create_time, update_time from student where id = #{id}")
    Student getById(Integer id);


    void update(Student student);

    @Update("update student set violation_count = violation_count + 1, violation_score = violation_score + #{score} where id = #{id}")
    void updateViolation(Integer id, Integer score);

    @MapKey("name")
    List<Map<String, Object>> countDegreeData();

    @MapKey("clazz")
    List<Map<String, Object>> getClazzData();

    @Select("select count(*) from student where clazz_id = #{clazzId}")
    int countByDeptId(Integer id);
}
