package JDBCutils;

import dao.BaseDAO;
import datebean.CPI_CN;
import datebean.HouseRate;

import java.util.List;

import static dao.BaseDAO.selectDateForMany;
import static dao.BaseDAO.selectDateForOne;

public class QueryForHouse implements Query{
    /**
     *  实现对t_house 中所有数据的查询
     * @return 返回一个包含数据库中所有CPI_CN对象的List列表
     * @param <T> 返回的类型
     * @throws Exception
     */
    @Override
    public <T > T SelectMany() throws Exception {

        String sql = "SELECT date_House,rate_House FROM t_house WHERE date_House>=?;";

        Integer i = 1;

        List<CPI_CN> cpi = selectDateForMany(CPI_CN.class, sql,i);
        return (T) cpi;
    }



    /**
     * 实现对t_house 表中的某一年份的数据进行查询
     *
     * @param years 查询年份
     * @param <T>   返回的类型
     * @return
     */
    @Override
    public <T > HouseRate selectOne(Integer years) {

        String sql ="SELECT date_House,rate_House FROM t_house WHERE date_House>=?;";

        HouseRate house= null;
        try {
            house = selectDateForOne(HouseRate.class, sql, years);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return house;
    }
}
