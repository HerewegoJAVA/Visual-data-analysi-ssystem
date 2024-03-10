package JDBCutils;

import dao.BaseDAO;
import datebean.CPI_CN;

public interface Query {

    //查询多列数据

    <T >T SelectMany()throws Exception;

    //查询单列数据,参数years 表示查询年份
    <T > Object selectOne(Integer years);
}
