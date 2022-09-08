package com.christer.imperial.court.service.api;

import com.christer.imperial.court.entity.Emp;

/**
 * Description:
 *
 * @author Christer.Hong
 * @version 1.0
 * @date 2022/09/08
 */
public interface EmpService {
    Emp getEmpByLogin(String loginAccount, String loginPassword);
}
