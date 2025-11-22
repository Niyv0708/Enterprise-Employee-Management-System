package online.niyv0708.service;

import online.niyv0708.pojo.Dept;
import online.niyv0708.pojo.Result;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DeptService {
    List<Dept> findAll();

    void deleteById(Integer id);

    void add(Dept dept);

    Dept getById(Integer id);

    void update(Dept dept);


}
