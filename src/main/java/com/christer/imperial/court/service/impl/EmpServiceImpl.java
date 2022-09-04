package com.christer.imperial.court.service.impl;

import com.christer.imperial.court.dao.api.EmpDao;
import com.christer.imperial.court.dao.impl.EmpDaoImpl;
import com.christer.imperial.court.entity.Emp;
import com.christer.imperial.court.service.api.EmpService;
import com.christer.imperial.court.util.MD5Util;

/**
 * @author Christer
 * @version 1.0
 * @date 2022-09-04 15:38
 * Description:
 */
public class EmpServiceImpl implements EmpService {

    private EmpDao empDao = new EmpDaoImpl();

    @Override
    public Emp getEmpByLoginAccount(String loginAccount, String loginPassword) {
        String encodedLoginPassword = MD5Util.encode(loginPassword);

    }
}
