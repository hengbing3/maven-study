package com.christer.imperial.court.service.api;

import com.christer.imperial.court.entity.Emp;

/**
 * @author Christer
 * @version 1.0
 * @date 2022-09-04 15:38
 * Description:
 */
public interface EmpService {
    Emp getEmpByLoginAccount(String loginAccount, String loginPassword);
}
