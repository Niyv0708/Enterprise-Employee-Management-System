package online.niyv0708.service.impl;

import online.niyv0708.exception.DeptHasEmployeesException;
import online.niyv0708.mapper.DeptMapper;
import online.niyv0708.mapper.EmpMapper;
import online.niyv0708.pojo.Dept;
import online.niyv0708.pojo.Result;
import online.niyv0708.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;
    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        int empCount = empMapper.countByDeptId(id);

        // 2. 若存在员工，抛出异常
        if (empCount > 0) {
            throw new DeptHasEmployeesException();
        }

        // 3. 若不存在员工，执行删除操作
        deptMapper.deleteById(id);
    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }

    @Override
    public Dept getById(Integer id) {
        return deptMapper.getById(id);
    }

    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }

}
