package online.niyv0708.mapper;

import online.niyv0708.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpExprMapper {
    void deleteByEmpIds(List<Integer> empIds);

    void insertBatch(List<EmpExpr> exprList);

}
