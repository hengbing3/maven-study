package com.christer.imperial.court.dao.api;

import com.christer.imperial.court.entity.Emp;

/**
 * Description:
 *
 * @author Christer.Hong
 * @version 1.0
 * @date 2022/09/02
 */
public interface EmpDao {
    Emp selectEmpByLoginAccount(String loginAccount, String encodedLoginPassword);
}
