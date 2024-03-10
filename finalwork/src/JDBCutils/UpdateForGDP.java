package JDBCutils;

import static dao.BaseDAO.upData;

public class UpdateForGDP  implements Update {

    @Override
    public int Insert(Integer years, Double rate) throws Exception {
        return 0;
    }

    /**
     * 实现对t_gdp的指定行实现 增 操作
     * @param years 年份
     * @param rate 比率
     * @return 是否正确执行
     * @throws Exception
     */
    @Override
    public int Insert(Integer years, Double number, Double rate) throws Exception {
        String sql = "INSERT  INTO t_gdp(date_GDP,gdp_Number,world_Rate ) VALUES(?,?,?);";
        int i = upData(sql, years,number, rate);
        if (i!=-1){
            return 0;
        }else return -1;

    }

    /**
     * 实现对t_gdp的指定行实现 删 操作
     * @param years 年份
     * @return 是否正确执行
     * @throws Exception
     */

    @Override
    public int Drop(Integer years) throws Exception {
        String sql = "DELETE FROM t_gdp WHERE date_Brith= ?;";
        int i = upData(sql, years);
        if (i!=-1){
            return 0;
        }else return -1;
    }




    /**
     * 对t_gdp表中的单行数据进行更改
     * @param newYears 新的年份
     * @param newRate  新的比率
     * @param orderYear 旧的年份
     * @return
     * @throws Exception
     */
    @Override
    public int Update(Integer newYears,Double newRate, Double newWorld,Integer orderYear) throws Exception {
        String sql = "UPDATE t_gdp SET date_GDP=?,gdp_Number=?,world_Rate=? WHERE date_GDP=?;";
        int i = upData(sql, newYears,newRate,newWorld,orderYear);
        if (i!=-1){
            return 0;
        }else return -1;
    }

    /**
     * 不用这个方法
     * @param newYears
     * @param newRate
     * @param orderYear
     * @return
     * @throws Exception
     */
    @Override
      public int Update(Integer newYears, Double newRate, Integer orderYear) throws Exception {
        return 0;
    }



}
