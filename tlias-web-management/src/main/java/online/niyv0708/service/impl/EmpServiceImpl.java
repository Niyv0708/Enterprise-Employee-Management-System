package online.niyv0708.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import online.niyv0708.mapper.EmpExprMapper;
import online.niyv0708.mapper.EmpMapper;
import online.niyv0708.pojo.*;
import online.niyv0708.service.EmpService;
import online.niyv0708.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpExprMapper empExprMapper;
//    @Override
//    public PageResult<Emp> page(Integer page, Integer pageSize) {
//        Long total = empMapper.count();
//        Integer start = (page - 1) * pageSize;
//        List<Emp> rows = empMapper.list(start, pageSize);
//        return new PageResult<>(total, rows);
//    }
    @Override
    public PageResult<Emp> page(EmpQueryParam empQueryParam) {

        PageHelper.startPage(empQueryParam.getPage(),empQueryParam.getPageSize());

        List<Emp> empList = empMapper.list(empQueryParam);

        Page<Emp> p = (Page<Emp>) empList;
        return new PageResult<>(p.getTotal(), p.getResult());
    }


    @Override
    @Transactional
    public void save(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);

        List<EmpExpr> exprList = emp.getExprList();
        if(!CollectionUtils.isEmpty(exprList)){
//            for (EmpExpr empExpr : exprList) {
//                empExpr.setEmpId(emp.getId());
//            }
            exprList.forEach(empExpr -> {
                empExpr.setEmpId(emp.getId());

            });
            empExprMapper.insertBatch(exprList);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(List<Integer> ids) {
        empMapper.deleteByIds(ids);
        empExprMapper.deleteByEmpIds(ids);
    }



    @Override
    public Emp getInfo(Integer id) {
        return empMapper.getById(id);
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
        empExprMapper.deleteByEmpIds(Arrays.asList(emp.getId()));
        List<EmpExpr> exprList = emp.getExprList();
        if(!CollectionUtils.isEmpty(exprList)){
            exprList.forEach(empExpr -> {
                empExpr.setEmpId(emp.getId());
            });
        }
        empExprMapper.insertBatch(exprList);
    }

    @Override
    public List<Emp> findAll() {
        return empMapper.findAll();
    }

    @Override
    public LoginInfo login(Emp emp) {
       Emp e =  empMapper.SelectByUsernameAndPassword(emp);

       if(e != null) {
           Map<String,Object> claims = new HashMap<>();
           claims.put("id",e.getId());
           claims.put("username",e.getUsername());
           String jwt = JwtUtils.generateJwt(claims);
           return new LoginInfo(e.getId(), e.getUsername(),e.getName(),jwt);
       }
       return null;
    }

}
