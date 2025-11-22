package online.niyv0708.mapper;

import online.niyv0708.pojo.Clazz;
import online.niyv0708.pojo.ClazzQueryParam;
import online.niyv0708.pojo.Emp;
import online.niyv0708.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ClazzMapper {
    List<Clazz> list(ClazzQueryParam clazzQueryParam);

    @Delete("delete from clazz where id=#{id}")
    void deleteById(Integer id);

    @Insert("insert into clazz(name, room, begin_date, end_date, master_id, subject, create_time, update_time) " +
            "values(#{name}, #{room}, #{beginDate}, #{endDate}, #{masterId}, #{subject},#{createTime},#{updateTime})")
    void insert(Clazz clazz);

    @Select("select id, name, room, begin_date, end_date, master_id, subject, create_time, update_time from clazz where id=#{id}")
    Clazz getById(Integer id);
    @Update("update clazz set name=#{name}, room=#{room}, begin_date=#{beginDate}, end_date=#{endDate}, master_id=#{masterId}, subject=#{subject}, update_time=#{updateTime} where id=#{id}")
    void update(Clazz clazz);
    @Select("select id, name, room, begin_date, end_date, master_id, subject, create_time, update_time from clazz")
    List<Clazz> findAll();
}