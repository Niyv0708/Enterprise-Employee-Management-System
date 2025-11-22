package online.niyv0708.service;

import online.niyv0708.pojo.Emp;
import online.niyv0708.pojo.EmpQueryParam;
import online.niyv0708.pojo.LoginInfo;
import online.niyv0708.pojo.PageResult;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface EmpService {
//    PageResult<Emp> page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end);
    PageResult<Emp> page(EmpQueryParam empQueryParam);

    void save(Emp emp);

    void delete(List<Integer> ids);

    Emp getInfo(Integer id);

    void update(Emp emp);

    List<Emp> findAll();

    LoginInfo login(Emp emp);
}
