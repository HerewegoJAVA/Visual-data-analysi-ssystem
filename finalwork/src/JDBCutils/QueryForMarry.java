package JDBCutils;

import dao.BaseDAO;
import datebean.CPI_CN;
import datebean.MarriageRate;

import java.util.List;

import static dao.BaseDAO.selectDateForMany;
import static dao.BaseDAO.selectDateForOne;

public class QueryForMarry implements Query{
    /**
     *  实现对t_marriage中所有数据的查询
     * @return 返回一个包含数据库中所有CPI_CN对象的List列表
     * @param <T> 返回的类型
     * @throws Exception
     */
    @Override
    public <T > T SelectMany() throws Exception {

        String sql = "SELECT date_Marr,marr_Rate FROM t_marriage WHERE date_Marr>=1;";

        Integer i = 1;

        List<MarriageRate> marr = selectDateForMany(MarriageRate.class, sql,i);
        return (T) marr;
    }



    /**
     * 实现对t_marriage表中的某一年份的数据进行查询
     *
     * @param years 查询年份
     * @param <T>   返回的类型
     * @return
     */
    @Override
    public <T > MarriageRate selectOne(Integer years) {

        String sql ="SELECT date_Marr,marr_Rate FROM t_marriage WHERE date_Marr=?;";

        MarriageRate marr = null;
        try {
            marr = selectDateForOne(MarriageRate.class, sql, years);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return marr;
    }
}
