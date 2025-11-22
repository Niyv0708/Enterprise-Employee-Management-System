package online.niyv0708.service;
import online.niyv0708.pojo.ClazzOption;
import online.niyv0708.pojo.JobOption;

import java.util.List;
import java.util.Map;

public interface ReportService {
    JobOption getEmpJobData();

    List<Map<String, Object>> getGenderData();


    List<Map<String, Object>> getStudentDegreeData();

    ClazzOption getClazzData();
}
