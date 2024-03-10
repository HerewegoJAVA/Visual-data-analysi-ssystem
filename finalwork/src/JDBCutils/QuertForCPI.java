package JDBCutils;

import dao.BaseDAO;
import datebean.BrithRate;
import datebean.CPI_CN;

import java.util.List;

import static dao.BaseDAO.selectDateForMany;
import static dao.BaseDAO.selectDateForOne;

public class QuertForCPI implements Query {
    /**
     *  实现对t_cpi中所有数据的查询
     * @return 返回一个包含数据库中所有CPI_CN对象的List列表
     * @param <T> 返回的类型
     * @throws Exception
     */
    @Override
    public <T > T SelectMany() throws Exception {

        String sql = "SELECT date_CPI,cpi_Rate FROM t_cpi WHERE date_CPI>=?;";

        Integer i = 1987;

        List<CPI_CN> cpi = selectDateForMany(CPI_CN.class, sql,i);
        return (T) cpi;
    }



    /**
     * 实现对t_cpi表中的某一年份的数据进行查询
     *
     * @param years 查询年份
     * @param <T>   返回的类型
     * @return
     */
    @Override
    public <T > CPI_CN selectOne(Integer years) {

        String sql ="SELECT date_CPI,cpi_Rate FROM t_cpi WHERE date_CPI=?;";

        CPI_CN cpi = null;
        try {
            cpi = selectDateForOne(CPI_CN.class, sql, years);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return cpi;
    }
}
