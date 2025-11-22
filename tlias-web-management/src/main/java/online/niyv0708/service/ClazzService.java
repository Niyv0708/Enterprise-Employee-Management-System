package online.niyv0708.service;

import online.niyv0708.pojo.Clazz;
import online.niyv0708.pojo.ClazzQueryParam;
import online.niyv0708.pojo.PageResult;

import java.util.List;

public interface ClazzService {

    PageResult<Clazz> page(ClazzQueryParam clazzQueryParam);

    void deleteById(Integer id);

    void save(Clazz clazz);


    Clazz getById(Integer id);

    void update(Clazz clazz);

    List<Clazz> findAll();
}
