package JDBCutils;

import dao.BaseDAO;

import java.util.List;

public interface Update {

    //增加，删除，修改一个数据,如果返回-1 说明插入失败


    int Insert(Integer years, Double rate) throws Exception;

    int Insert(Integer years, Double number, Double rate) throws Exception;

    //删除指定年份的一个数据,如果返回-1 说明删除失败
    int Drop(Integer years) throws Exception;

    //增加一个数据,如果返回-1 说明插入失败
    int Update(Integer newYears,Double newRate,Integer orderYear) throws Exception;

    //增加一个数据,如果返回-1 说明插入失败
    int Update(Integer newYears,Double newRate, Double newWorld,Integer orderYear) throws Exception;
}
