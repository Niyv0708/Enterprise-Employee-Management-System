package online.niyv0708.service.impl;

import online.niyv0708.mapper.ClazzMapper;
import online.niyv0708.mapper.EmpMapper;
import online.niyv0708.mapper.StudentMapper;
import online.niyv0708.pojo.ClazzOption;
import online.niyv0708.pojo.JobOption;
import online.niyv0708.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public JobOption getEmpJobData() {
        List<Map<String,Object>> List = empMapper.countEmpJobData();
        List<Object> jobList = List.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> dataList = List.stream().map(dataMap -> dataMap.get("total")).toList();
        return new JobOption(jobList,dataList);

    }

    @Override
    public List<Map<String, Object>> getGenderData() {

        return empMapper.getGenderData();
    }



    @Override
    public List<Map<String, Object>> getStudentDegreeData() {

        return studentMapper.countDegreeData();
    }

    @Override
    public ClazzOption getClazzData() {
        List<Map<String,Object>> List = studentMapper.getClazzData();
        List<Object> clazzList = List.stream().map(dataMap -> dataMap.get("clazz")).toList();
        List<Object> dataList = List.stream().map(dataMap -> dataMap.get("total")).toList();
        return new ClazzOption(clazzList,dataList);
    }
}
