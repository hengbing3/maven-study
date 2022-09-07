package com.christer.imperial.court.mapper;

import com.christer.imperial.court.entity.Memorials;
import com.christer.imperial.court.entity.MemorialsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemorialsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_memorials
     *
     * @mbggenerated Wed Sep 07 19:11:24 CST 2022
     */
    int countByExample(MemorialsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_memorials
     *
     * @mbggenerated Wed Sep 07 19:11:24 CST 2022
     */
    int deleteByExample(MemorialsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_memorials
     *
     * @mbggenerated Wed Sep 07 19:11:24 CST 2022
     */
    int deleteByPrimaryKey(Integer memorialsId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_memorials
     *
     * @mbggenerated Wed Sep 07 19:11:24 CST 2022
     */
    int insert(Memorials record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_memorials
     *
     * @mbggenerated Wed Sep 07 19:11:24 CST 2022
     */
    int insertSelective(Memorials record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_memorials
     *
     * @mbggenerated Wed Sep 07 19:11:24 CST 2022
     */
    List<Memorials> selectByExample(MemorialsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_memorials
     *
     * @mbggenerated Wed Sep 07 19:11:24 CST 2022
     */
    Memorials selectByPrimaryKey(Integer memorialsId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_memorials
     *
     * @mbggenerated Wed Sep 07 19:11:24 CST 2022
     */
    int updateByExampleSelective(@Param("record") Memorials record, @Param("example") MemorialsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_memorials
     *
     * @mbggenerated Wed Sep 07 19:11:24 CST 2022
     */
    int updateByExample(@Param("record") Memorials record, @Param("example") MemorialsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_memorials
     *
     * @mbggenerated Wed Sep 07 19:11:24 CST 2022
     */
    int updateByPrimaryKeySelective(Memorials record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_memorials
     *
     * @mbggenerated Wed Sep 07 19:11:24 CST 2022
     */
    int updateByPrimaryKey(Memorials record);
}