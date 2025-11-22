package online.niyv0708.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class StudentQueryParam {
    private String name; //班级名称
    private Integer degree;
    private Integer clazzId;
    private Integer page = 1; //页码
    private Integer pageSize = 10; //每页展示记录数
}
