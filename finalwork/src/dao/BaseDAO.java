package dao;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import datebean.BrithRate;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

/**
 * 通过durid 技术实现对数据库的连接
 */
public  class  BaseDAO {

    //使用静态代码块唯一创建数据连接池
    private  static DruidDataSource dataSource;
    static {
        try{
                //读取配置文件信息
        Properties pros = new Properties();
        InputStream in = BaseDAO.class.getResourceAsStream("druid.properties");
        pros.load(in);
        //通过Druid数据库连接池技术获取连接
       dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(pros);

    }catch (SQLException e) {
                throw new RuntimeException(e);} catch (IOException e) {} catch (Exception e) {
                throw new RuntimeException(e);
            }
    }

    /**
     * 获取数据库连接
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws Exception {

        Connection connection = dataSource.getConnection();
        return connection;
    }

    /**
     * 用来执行insert，delete，update操作,返回-1说明操作失败
     */
    private static QueryRunner queryRunner = new QueryRunner();
    public static int upData(String sql,Object...args) throws Exception {
        Connection con = null;
        try {
            con = getConnection();
            return queryRunner.update(con, sql, args);
        } finally {
            if (con != null) {
                con.close();
            }
            else
                return -1;
        }
    }

    /**
     *查询返回一条记录
     * @param type 返回的对象类型
     * @param sql  执行的sql语句
     * @param args  sql参数
     * @return
     * @param <T>  返回的类型的泛型
     * @throws Exception
     */

    public static <T>T  selectDateForOne(Class<T>type,String sql,Object...args) throws Exception {
        Connection con = null;
        try {
            con=getConnection();
            return queryRunner.query(con, sql, new BeanHandler<>(type),args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if(con!=null){
                con.close();
            }
//            return null;
        }
    }

    /**
     *查询返回多个对象
     * @param type 返回的对象类型
     * @param sql  执行的sql语句
     * @param args  sql参数
     * @return
     * @param <T>  返回的类型的泛型
     * @throws Exception
     */
    public static <T> List<T> selectDateForMany(Class<T> type, String sql, Object...args) throws Exception {
        Connection con = null;
        try {
            con=getConnection();
            return queryRunner.query(con,sql, new BeanListHandler<T>(type),args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if(con!=null){
                con.close();
            }
//            return null;
        }
    }

    /**
     * 查询返回一个对象中的某一个值
     * @param sql
     * @param args
     * @return
     * @throws Exception
     */
    public static  Object selectDateOneValues( String sql, Object...args) throws Exception {
        Connection con = null;

        try {
            con=getConnection();
            return queryRunner.query(con,sql,new ScalarHandler(),args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if(con!=null){
                con.close();
            }
            return null;
        }

    }
}




