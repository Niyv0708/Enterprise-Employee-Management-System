package online.niyv0708.exception;

import lombok.extern.slf4j.Slf4j;
import online.niyv0708.pojo.Result;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public Result handleException(Exception e){
        log.error("服务器发生异常：{}",e.getMessage());
        return Result.error("服务器异常");
    }
    @ExceptionHandler
    public Result handleDuplicateKeyException(DuplicateKeyException e){
        log.error("服务器发生异常：{}",e.getMessage());
        String message = e.getMessage();
        int index = message.indexOf("Duplicate entry");
        String errMsg = message.substring(index);
        String[] arr = errMsg.split(" ");
        return Result.error(arr[2] + "已存在");
    }
    @ExceptionHandler
    public Result handleDeptHasEmployeesException(DeptHasEmployeesException e) {
        log.error("部门删除失败：部门下存在员工");
        return Result.error("对不起，当前部门下有员工，不能直接删除！");
    }

    @ExceptionHandler
    public Result handleClazzHasStudentsException(ClazzHasStudentsException e) {
        log.error("班级删除失败：班级下有学生");
        return Result.error("对不起，当前班级下有学生，不能直接删除！");
    }
}
