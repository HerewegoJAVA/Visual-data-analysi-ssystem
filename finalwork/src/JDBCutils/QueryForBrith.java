package JDBCutils;

import dao.BaseDAO;
import datebean.BrithRate;

import java.util.List;

/**
 * 实现对t_birth表中的数据进行单、多行的查询
 */
public class QueryForBrith extends BaseDAO implements Query{


    /**
     *  实现对t_birth中所有数据的查询
     * @return 返回一个包含数据库中所有BruthRate对象的List列表
     * @param <T> 返回的类型
     * @throws Exception
     */
    @Override
    public <T > T SelectMany() throws Exception {

        String sql = "SELECT date_Brith,brith_Years FROM t_birth WHERE date_Brith>=? ";

        Integer i = 1959;

        List<BrithRate> rates = selectDateForMany(BrithRate.class, sql,i);
        return (T) rates;
    }



    /**
     * 实现对t_birth表中的某一年份的数据进行查询
     *
     * @param years 查询年份
     * @param <T>   返回的类型
     * @return
     */
    @Override
    public <T > BrithRate selectOne(Integer years) {

        String sql ="SELECT date_Brith,brith_Years FROM t_birth WHERE date_Brith =?";

        BrithRate rate = null;
        try {
            rate = selectDateForOne(BrithRate.class, sql, years);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return rate;
    }
}
