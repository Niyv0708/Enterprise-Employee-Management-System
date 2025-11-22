package online.niyv0708.controller;

import lombok.extern.slf4j.Slf4j;
import online.niyv0708.pojo.ClazzOption;
import online.niyv0708.pojo.JobOption;
import online.niyv0708.pojo.Result;
import online.niyv0708.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("/report")
@RestController
public class ReportController {
    @Autowired
    private ReportService reportService;

    @GetMapping("/empJobData")
    public Result getEmpJobData() {
        log.info("获取各职位人数");
        JobOption jobOption = reportService.getEmpJobData();
        return Result.success(jobOption);
    }

    @GetMapping("/empGenderData")
    public Result getGenderData() {
        log.info("获取男女性别人数");
        List<Map<String,Object>> genderList = reportService.getGenderData();
        return Result.success(genderList);
    }

    @GetMapping("/studentDegreeData")
    public Result getStudentDegreeData() {
        log.info("获取各学历人数");
        List<Map<String,Object>> gradeList= reportService.getStudentDegreeData();
        return Result.success(gradeList);
    }
    @GetMapping("/studentCountData")
    public Result getStudentCountData() {
        log.info("获取各班级人数");
        ClazzOption clazzOption = reportService.getClazzData();
        return Result.success(clazzOption);

    }
}
