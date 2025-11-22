package online.niyv0708.service;

import online.niyv0708.pojo.OperateQueryParam;
import online.niyv0708.pojo.OperateLog;
import online.niyv0708.pojo.PageResult;

public interface OperateService {
    PageResult<OperateLog> page(OperateQueryParam logQueryParam);
}
