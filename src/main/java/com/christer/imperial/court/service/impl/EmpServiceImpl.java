package com.christer.imperial.court.service.impl;

import com.christer.imperial.court.dao.api.EmpDao;
import com.christer.imperial.court.dao.impl.EmpDaoImpl;
import com.christer.imperial.court.entity.Emp;
import com.christer.imperial.court.exception.LoginFailedException;
import com.christer.imperial.court.service.api.EmpService;
import com.christer.imperial.court.util.ImperialCourtConst;
import com.christer.imperial.court.util.MD5Util;

/**
 * @author Christer
 * @version 1.0
 * @date 2022-09-04 15:38
 * Description:
 */
public class EmpServiceImpl implements EmpService {

    private final EmpDao empDao = new EmpDaoImpl();

    @Override
    public Emp getEmpByLoginAccount(String loginAccount, String loginPassword) {
        // 1、对密码执行加密
        String encodedLoginPassword = MD5Util.encode(loginPassword);
        // 2、根据账户和加密密码查询数据库
        Emp emp = empDao.selectEmpByLoginAccount(loginAccount, encodedLoginPassword);
        // 3、检查Emp 对象是否为null
        // ①不为null：返回 Emp
        if (emp != null) {
            return emp;
        // ②为null：抛出登录失败异常
        } else {
            throw new LoginFailedException(ImperialCourtConst.LOGIN_FAILED_MESSAGE);
        }
    }
}
