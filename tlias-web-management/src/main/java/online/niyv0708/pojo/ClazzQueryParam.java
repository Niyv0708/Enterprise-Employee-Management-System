package online.niyv0708.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ClazzQueryParam {
    private String name; //班级名称
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin; //范围匹配的开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end; //范围匹配的结束时间
    private Integer page = 1; //页码
    private Integer pageSize = 10; //每页展示记录数
}
