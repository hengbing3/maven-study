package com.christer.imperial.court.service.impl;

import com.christer.imperial.court.entity.Emp;
import com.christer.imperial.court.entity.EmpExample;
import com.christer.imperial.court.mapper.EmpMapper;
import com.christer.imperial.court.service.api.EmpService;
import com.christer.imperial.court.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Description:
 *
 * @author Christer.Hong
 * @version 1.0
 * @date 2022/09/08
 */
@Service
@Transactional(readOnly = true)
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;
    @Override
    public Emp getEmpByLogin(String loginAccount, String loginPassword) {

       // 1、密码加密
        String encodedLoginPassword = MD5Util.encode(loginPassword);

        // 2、通过 QBC 查询方式封装查询条件
        EmpExample example = new EmpExample();

        EmpExample.Criteria criteria = example.createCriteria();

        criteria.andLoginAccountEqualTo(loginAccount).andLoginPasswordEqualTo(encodedLoginPassword);

        List<Emp> empList = empMapper.selectByExample(example);

        if (empList != null && empList.size() > 0) {
            // 3、返回查询结果
            return empList.get(0);
        }

        return null;

    }
}
