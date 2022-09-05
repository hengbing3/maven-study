package com.christer.imperial.court.dao.impl;

import com.christer.imperial.court.dao.BaseDao;
import com.christer.imperial.court.dao.api.MemorialsDao;
import com.christer.imperial.court.entity.Memorials;

import java.util.List;

/**
 * Description:
 *
 * @author Christer.Hong
 * @version 1.0
 * @date 2022/09/02
 */
public class MemorialsDaoImpl extends BaseDao<Memorials> implements MemorialsDao {
    @Override
    public List<Memorials> selectAllMemorialsDigest() {
        String sql = "SELECT\n" +
                "\tmemorials_id memorialsId,\n" +
                "\tmemorials_title memorialsTitle,\n" +
                "\tCONCAT(LEFT(memorials_content,10),\"...\") memorialsContentDigest,\n" +
                "\temp_name memorialsEmpName,\n" +
                "\tmemorials_create_time memorialsCreateTime,\n" +
                "\tmemorials_status memorialsStatus\n" +
                "FROM\n" +
                "\tt_memorials m LEFT JOIN t_emp e ON m.memorials_emp = e.emp_id";
        return getBeanList(sql,Memorials.class);
    }
}
