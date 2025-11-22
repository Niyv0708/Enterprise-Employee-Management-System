package online.niyv0708.controller;

import lombok.extern.slf4j.Slf4j;
import online.niyv0708.anno.Log;
import online.niyv0708.pojo.Dept;
import online.niyv0708.pojo.Result;
import online.niyv0708.service.DeptService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {
//    private static final Logger log = LoggerFactory.getLogger(DeptController.class);
    @Autowired
    private DeptService deptService;
    @GetMapping
    public Result list(){
        log.info("查询所有部门信息：");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }

    @Log
    @DeleteMapping
    public Result delete(Integer id)  throws Exception{
        log.info("根据id删除部门：{}", id);
        deptService.deleteById(id);
        return Result.success();
    }
    @Log
    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("添加部门：{}",dept);
        deptService.add(dept);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("查询部门：{}",id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }
    @Log
    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("更新部门：{}",dept);
        deptService.update(dept);
        return Result.success();
    }
}
