package JDBCutils;

import dao.BaseDAO;
import datebean.CPI_CN;
import datebean.GDP_CN;

import java.util.List;

import static dao.BaseDAO.selectDateForMany;
import static dao.BaseDAO.selectDateForOne;

public class QueryForGDP  implements Query {
    /**
     *  实现对t_cpi中所有数据的查询
     * @return 返回一个包含数据库中所有CPI_CN对象的List列表
     * @param <T> 返回的类型
     * @throws Exception
     */
    @Override
    public <T > T SelectMany() throws Exception {

        String sql = "SELECT date_GDP,gdp_Number,world_Rate FROM t_gdp WHERE date_GDP>=?;";

        Integer i = 1960;

        List<GDP_CN> gdp = selectDateForMany(GDP_CN.class, sql,i);
        return (T) gdp;
    }



    /**
     * 实现对t_cpi表中的某一年份的数据进行查询
     *
     * @param years 查询年份
     * @param <T>   返回的类型
     * @return
     */
    @Override
    public <T > GDP_CN selectOne(Integer years) {

        String sql ="SELECT date_GDP,gdp_Number,world_Rate FROM t_gdp WHERE date_GDP=?;";

        GDP_CN gdp = null;
        try {
            gdp = selectDateForOne(GDP_CN.class, sql, years);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return gdp;
    }
}
