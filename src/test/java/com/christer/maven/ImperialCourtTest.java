package com.christer.maven;

import com.christer.imperial.court.dao.BaseDao;
import com.christer.imperial.court.entity.Emp;
import com.christer.imperial.court.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

/**
 * Description:
 *
 * @author Christer.Hong
 * @version 1.0
 * @date 2022/09/02
 */
public class ImperialCourtTest {

    private BaseDao<Emp> baseDao = new BaseDao<>();

    @Test
    public void testGetSingleBean() {
        String sql = "select emp_id empId,emp_name empName,emp_position empPosition,login_account loginAccount,login_password loginPassword from t_emp where emp_id = ?";
        Emp emp = baseDao.getSingleBean(sql, Emp.class, 1);
        System.out.println("emp = " + emp);
    }

    @Test
    public void testGetBeanList() {
        String sql = "select emp_id empId,emp_name empName,emp_position empPosition,login_account loginAccount,login_password loginPassword from t_emp";
        List<Emp> empList = baseDao.getBeanList(sql, Emp.class);
        empList.forEach(System.out::println);
    }

    @Test
    public void testUpdate() {
        String sql = "update t_emp set emp_position = ? where emp_id = ?";

        String empPosition = "minister";
        String empId = "3";

        int update = baseDao.update(sql, empPosition, empId);
        System.out.println("affectedRowNumber = " + update);
    }


    @Test
    public  void testGetConnection() {
        Connection connection = JDBCUtils.getConnection();
        System.out.println("connection = " + connection);

        JDBCUtils.releaseConnection(connection);
    }
}
