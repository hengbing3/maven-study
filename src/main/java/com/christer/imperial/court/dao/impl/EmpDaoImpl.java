package com.christer.imperial.court.dao.impl;

import com.christer.imperial.court.dao.BaseDao;
import com.christer.imperial.court.dao.api.EmpDao;
import com.christer.imperial.court.entity.Emp;

/**
 * Description:
 *
 * @author Christer.Hong
 * @version 1.0
 * @date 2022/09/02
 */
public class EmpDaoImpl extends BaseDao<Emp> implements EmpDao {
    @Override
    public Emp selectEmpByLoginAccount(String loginAccount, String encodedLoginPassword) {
        // 1、编写 SQL 语句
        String sql = "select emp_id empId," +
                "emp_name empName," +
                "emp_position empPosition," +
                "login_account loginAccount," +
                "login_password loginPassword " +
                "from t_emp where login_account=? and login_password=?";
        return getSingleBean(sql,Emp.class,loginAccount,encodedLoginPassword);
    }
}
