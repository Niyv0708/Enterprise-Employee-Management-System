package online.niyv0708.mapper;

import online.niyv0708.pojo.Emp;
import online.niyv0708.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Mapper
public interface EmpMapper {

//    @Select("select count(*)from emp e  left join dept d  on d.id = e.dept_id ")
//    public Long count();
//
//    @Select("select e.*,d.name deptName from emp e  left join dept d  on d.id = e.dept_id order by e.update_time desc limit #{start},#{pageSize}")
//    public List<Emp> list(Integer start,Integer pageSize);

//    @Select("select e.*,d.name deptName from emp e  left join dept d  on d.id = e.dept_id order by e.update_time desc ")
    public List<Emp> list(EmpQueryParam empQueryParam);
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into emp(username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time) " +
            "VALUES (#{username},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);

    void deleteByIds(List<Integer> ids);
    @Select("select count(*) from emp where dept_id = #{deptId}")
    int countByDeptId(Integer deptId);

    Emp getById(Integer id);

    void update(Emp emp);

    @MapKey("pos")
    List<Map<String,Object>> countEmpJobData();

    @MapKey("name")
    List<Map<String, Object>> getGenderData();
    @Select("select ID, USERNAME, PASSWORD, NAME, GENDER, PHONE, JOB, SALARY, IMAGE, ENTRY_DATE, DEPT_ID, CREATE_TIME, UPDATE_TIME from emp")
    List<Emp> findAll();

    @Select("select id, username, name from emp where username = #{username} and password = #{password}")
    Emp SelectByUsernameAndPassword(Emp emp);
}
