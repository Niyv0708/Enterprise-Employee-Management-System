package online.niyv0708.controller;

import lombok.extern.slf4j.Slf4j;
import online.niyv0708.pojo.OperateQueryParam;
import online.niyv0708.pojo.OperateLog;
import online.niyv0708.pojo.PageResult;
import online.niyv0708.pojo.Result;
import online.niyv0708.service.OperateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/log/page")
public class LogController {
    @Autowired
    private OperateService operateService;
    @GetMapping
    public Result page(OperateQueryParam operateQueryParam){
        log.info("分页查询{}", operateQueryParam);
        PageResult<OperateLog> pageResult = operateService.page(operateQueryParam);
        return Result.success(pageResult);
    }
}
