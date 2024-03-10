package JDBCutils;

import dao.BaseDAO;
import datebean.CPI_CN;

import java.util.List;

import static dao.BaseDAO.*;

public class UpdateForMarry implements Update {
    /**
     * 实现对t_birth的指定行实现 增 操作
     * @param years 年份
     * @param rate 比率
     * @return 是否正确执行
     * @throws Exception
     */
    @Override
    public int Insert(Integer years,Double rate) throws Exception {
        String sql = "INSERT INTO t_marriage(date_Marr,marr_Rate) VALUES(?,?);";
        int i = upData(sql, years, rate);
        if (i!=-1){
            return 0;
        }else return -1;

    }

    @Override
    public int Insert(Integer years, Double number, Double rate) throws Exception {
        return 0;
    }

    /**
     * 实现对t_birth的指定行实现 删 操作
     * @param years 年份
     * @return 是否正确执行
     * @throws Exception
     */

    @Override
    public int Drop(Integer years) throws Exception {
        String sql = "DELETE FROM t_marriage WHERE date_Marr=?;";
        int i = upData(sql, years);
        if (i!=-1){
            return 0;
        }else return -1;
    }


    /**
     * 实现对t_marriage的指定行实现 改 操作
     * @param newYears 新的年份
     * @param newRate 新的比率
     * @return 是否正确执行
     * @throws Exception
     */
    @Override
    public int Update(Integer newYears,Double newRate,Integer orderYear) throws Exception {
        String sql = "UPDATE t_marriage SET date_Marr=?,marr_Rate=? WHERE date_Marr=?;";
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



}
