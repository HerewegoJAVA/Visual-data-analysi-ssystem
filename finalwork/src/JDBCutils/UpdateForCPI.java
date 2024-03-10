package JDBCutils;

import dao.BaseDAO;

public class UpdateForCPI extends BaseDAO implements Update {
    /**
     * 实现对t_cpi的指定行实现 增 操作
     * @param years 年份
     * @param rate 比率
     * @return 是否正确执行
     * @throws Exception
     */
    @Override
    public int Insert(Integer years,Double rate) throws Exception {
        String sql = "INSERT  INTO t_cpi(date_CPI,cpi_Rate) VALUES(?,?);";
        int i = upData(sql, years, rate);
        if (i!=-1){
            return 0;
        }else return -1;

    }



    /**
     * 实现对t_cpi的指定行实现 删 操作
     * @param years 年份
     * @return 是否正确执行
     * @throws Exception
     */

    @Override
    public int Drop(Integer years) throws Exception {
        String sql = "DELETE FROM t_cpi WHERE date_CPI= ?;";
        int i = upData(sql, years);
        if (i!=-1){
            return 0;
        }else return -1;
    }


    /**
     * 对t_cpi中的单行数据进行更改
     * @param newYears 新的年份
     * @param newRate  新的比率
     * @param orderYear 旧的年份
     * @return
     * @throws Exception
     */
    @Override
    public int Update(Integer newYears,Double newRate,Integer orderYear) throws Exception {
        String sql = "UPDATE t_cpi SET date_CPI=?,cpi_Rate=? WHERE date_Brith=?;";
        int i = upData(sql, newYears,newRate,orderYear);
        if (i!=-1){
            return 0;
        }else return -1;
    }

    /**
     * 不用这个方法
     * @param newYears
     * @param newRate
     * @param newWorld
     * @param orderYear
     * @return
     * @throws Exception
     */
    @Override
    public int Update(Integer newYears, Double newRate, Double newWorld, Integer orderYear) throws Exception {
        return 0;
    }

    /**
     * 不用这个方法
     * @param years
     * @param number
     * @param rate
     * @return
     * @throws Exception
     */
    @Override
    public int Insert(Integer years, Double number, Double rate) throws Exception {
        return 0;
    }
}
