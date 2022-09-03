package com.christer.imperial.court.dao;

import com.christer.imperial.court.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Description:
 * BaseDao 类：所有Dao实现类的基类
 *
 * @param <T> 实体类类型
 * @author Christer.Hong
 * @version 1.0
 * @date 2022/09/02
 */
public class BaseDao<T> {

    // DBUtils 工具包提供的数据库操作对象
    private QueryRunner runner = new QueryRunner();

    /**
     * 查询返回多个对象的方法
     *
     * @param sql         执行查询操作的 SQL 语句
     * @param entityClass 实体类对应的 Class 对象
     * @param parameters  传给 SQL 语句的参数
     * @return 查询到的实体类对象列表
     */
    public List<T> getBeanList(String sql, Class<T> entityClass, Object... parameters) {
        try {
            // 获取数据库连接
            Connection connection = JDBCUtils.getConnection();
            return runner.query(connection, sql, new BeanListHandler<>(entityClass), parameters);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询单个对象
     *
     * @param sql         执行查询的SQL语句
     * @param entityClass 实体类对应的Class对象
     * @param parameters  传给SQL语句的参数
     * @return 查询到的实体类对象
     */
    public T getSingleBean(String sql, Class<T> entityClass, Object... parameters) {

        try {
            // 获取数据库连接
            Connection connection = JDBCUtils.getConnection();
            return runner.query(connection, sql, new BeanHandler<>(entityClass), parameters);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    /**
     * 通用的增删改方法，insert,delete,update 操作都可以用这个方法
     *
     * @param sql        执行操作的SQL 语句
     * @param parameters SQL 语句的参数
     * @return 受影响的行数
     */
    public int update(String sql, Object... parameters) {
        try {
            Connection connection = JDBCUtils.getConnection();

            int affectedRowNumbers = runner.update(connection, sql, parameters);

            return affectedRowNumbers;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
