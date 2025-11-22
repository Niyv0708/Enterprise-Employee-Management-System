package online.niyv0708.pojo;

import lombok.Data;

@Data
public class OperateQueryParam {
    private Integer page = 1; //页码
    private Integer pageSize = 10; //每页展示记录数
}
