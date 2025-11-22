package online.niyv0708.controller;

import lombok.extern.slf4j.Slf4j;
import online.niyv0708.pojo.*;
import online.niyv0708.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/clazzs")
@RestController
public class ClazzController {

    @Autowired
    private ClazzService clazzService;
    @GetMapping

    public Result page(ClazzQueryParam ClazzQueryParam){

        log.info("分页查询，参数：ClazzQueryParam ={}",ClazzQueryParam);

        PageResult<Clazz> pageResult =  clazzService.page(ClazzQueryParam);

        return Result.success(pageResult);

    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("删除班级，id：{}",id);
        clazzService.deleteById(id);
        return Result.success();
    }
    @PostMapping
    public Result save(@RequestBody Clazz clazz){
        log.info("保存班级，数据：{}",clazz);
        clazzService.save(clazz);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("查询班级：{}",id);
        Clazz clazz = clazzService.getById(id);
        return Result.success(clazz);
    }

    @PutMapping
    public Result update(@RequestBody Clazz clazz){
        log.info("修改班级，数据：{}",clazz);
        clazzService.update(clazz);
        return Result.success();
    }
    @GetMapping("/list")
    public Result findAll(){
        log.info("查询所有班级");
        List<Clazz> clazzList = clazzService.findAll();
        return Result.success(clazzList);
    }

}