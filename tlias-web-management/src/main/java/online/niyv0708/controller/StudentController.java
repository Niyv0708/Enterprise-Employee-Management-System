package online.niyv0708.controller;

import lombok.extern.slf4j.Slf4j;
import online.niyv0708.pojo.PageResult;
import online.niyv0708.pojo.Result;
import online.niyv0708.pojo.Student;
import online.niyv0708.pojo.StudentQueryParam;
import online.niyv0708.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/students")

public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping
    public Result page(StudentQueryParam studentQueryParam){
        log.info("分页查询，参数：studentQueryParam ={}",studentQueryParam);
        PageResult<Student> pageResult = studentService.page(studentQueryParam);

        return Result.success(pageResult);
    }

    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("删除学生，ids：{}",ids);
        studentService.delete(ids);
        return Result.success();
    }

    @PostMapping
    public Result save(@RequestBody Student student){
        log.info("保存学生，数据：{}",student);
        studentService.save(student);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("查询学生：{}",id);
        Student student = studentService.getInfo(id);
        return Result.success(student);
    }

    @PutMapping
    public Result update(@RequestBody Student student){
        log.info("更新学生：{}",student);
        studentService.update(student);
        return Result.success();
    }

    @PutMapping("/violation/{id}/{score}")
    public Result updateViolation(@PathVariable Integer id,@PathVariable Integer score){
        log.info("更新学生：{}",id);
        studentService.updateViolation(id,score);
        return Result.success();
    }
}
