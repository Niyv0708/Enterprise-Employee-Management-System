package online.niyv0708.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import online.niyv0708.exception.DeptHasEmployeesException;
import online.niyv0708.mapper.ClazzMapper;
import online.niyv0708.mapper.StudentMapper;
import online.niyv0708.pojo.Clazz;
import online.niyv0708.pojo.ClazzQueryParam;
import online.niyv0708.pojo.Emp;
import online.niyv0708.pojo.PageResult;
import online.niyv0708.service.ClazzService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {
    @Autowired
    private ClazzMapper clazzMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public PageResult<Clazz> page(ClazzQueryParam clazzQueryParam) {
        PageHelper.startPage(clazzQueryParam.getPage(),clazzQueryParam.getPageSize());

        List<Clazz> clazzList = clazzMapper.list(clazzQueryParam);
        clazzList.forEach(clazz -> {
            if (clazz.getBeginDate() != null && clazz.getEndDate() != null) {
                LocalDate now = LocalDate.now();
                if (clazz.getBeginDate().isAfter(now)) {
                    clazz.setStatus("未开班");
                } else if ((clazz.getBeginDate().isBefore(now) || clazz.getBeginDate().isEqual(now))
                        && (clazz.getEndDate().isAfter(now) || clazz.getEndDate().isEqual(now))) {
                    clazz.setStatus("在读");
                } else if (clazz.getEndDate().isBefore(now)) {
                    clazz.setStatus("已结课");
                }
            }
        });

        Page<Clazz> p = (Page<Clazz>) clazzList;

        return new PageResult<>(p.getTotal(),p.getResult());
    }

    @Override
    public void deleteById(Integer id) {

        int studentCount = studentMapper.countByDeptId(id);
        // 2. 若存在员工，抛出异常
        if (studentCount > 0) {
            throw new DeptHasEmployeesException();
        }
        // 3. 若不存在员工，执行删除操作
        clazzMapper.deleteById(id);
    }

    @Override
    public void save(Clazz clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.insert(clazz);
    }

    @Override
    public Clazz getById(Integer id) {
        return clazzMapper.getById(id);
    }

    @Override
    public void update(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.update(clazz);
    }

    @Override
    public List<Clazz> findAll() {
        return clazzMapper.findAll();
    }


}
