package online.niyv0708.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import online.niyv0708.mapper.OperateLogMapper;
import online.niyv0708.pojo.OperateQueryParam;
import online.niyv0708.pojo.OperateLog;
import online.niyv0708.pojo.PageResult;
import online.niyv0708.service.OperateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperateServiceImpl implements OperateService {
    @Autowired
    private OperateLogMapper operateLogMapper;
    @Override
    public PageResult<OperateLog> page(OperateQueryParam operateQueryParam) {
        PageHelper.startPage(operateQueryParam.getPage(), operateQueryParam.getPageSize());
        List<OperateLog> operateLogList = operateLogMapper.list();
        Page<OperateLog> p = (Page<OperateLog>) operateLogList;
        return new PageResult<>(p.getTotal(), p.getResult());
    }
}
