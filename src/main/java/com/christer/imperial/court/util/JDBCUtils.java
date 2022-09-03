package com.christer.imperial.court.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Description:
 * 功能1：从数据源获取数据库连接
 * 功能2：从数据库获取到数据库连接后，绑定到本地线程（借助 ThreadLocal）
 * 功能3：释放线程时和本地线程解除绑定
 *
 * @author Christer.Hong
 * @version 1.0
 * @date 2022/09/01
 */
public class JDBCUtils {
    // 数据源成员变量设置为静态资源，保证大对象的单例性：同时保证静态方法中可以访问
    private static DataSource dataSource;

    // 由于 ThreadLocal 对象需要作为绑定数据时 k-v 对中的 key，所以要保证唯一性
// 加 static 声明为静态资源即可保证唯一性
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();


    // 在静态代码块中初始化数据源
    static {

        // 操作思路分析：
        // 从jdbc.properties 文件中读取连接数据库的信息
        // 为了保证程序代码的可移植性，需要基于一个确定的基准来读取这个文件
        // 确定的基准：类路径的根目录。resources 目录下的内容经过构建操作中的打包操作后会确定放在WEB-INF/classes目录下。
        // WEB-INF/classes 目录存放编译好的 *.class 字节码文件，所以这个目录我们就称之为类路径。

        // 1.创建一个用于存储外部属性文件信息的Properties对象
        Properties properties = new Properties();

        // 2.使用当前类的类加载器加载外部属性文件：jdbc.properties
        InputStream inputStream = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");

        try {

            // 3.将外部属性文件jdbc.properties中的数据加载到properties对象中
            properties.load(inputStream);

            // 4.创建数据源对象
            dataSource = DruidDataSourceFactory.createDataSource(properties);

        } catch (Exception e) {
            e.printStackTrace();
            // 为了避免在真正抛出异常后，catch 块捕获到异常从而掩盖问题，这里将所捕获到的异常封装为运行时异常继续抛出
            throw new RuntimeException(e);
        }
    }

    /**
     * 工具方法：获取数据库连接并返回
     *
     * @return
     */
    public static Connection getConnection() {
        Connection connection = null;
        try {
            // 1、尝试从当前线程检查是否存在绑定的 Connection 对象
            connection = threadLocal.get();

            //2、检查Connection 对象是否为null
            if (connection == null) {
                //3、如果为null，则从数据源获取数据库连接
                connection = dataSource.getConnection();

                //4、获取到数据库连接后绑定到当前线程
                threadLocal.set(connection);
            }
       } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static void releaseConnection(Connection connection) {
        if (connection != null) {
            try {
                // 在数据库连接池中将当前连接对象标记为空闲
                connection.close();
                // 将当前数据库连接从当前线程上移除
                threadLocal.remove();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }
}
