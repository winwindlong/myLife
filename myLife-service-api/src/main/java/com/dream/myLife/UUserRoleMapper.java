package com.dream.myLife;

import com.dream.myLife.user.entity.UUserRole;
import com.dream.myLife.user.entity.UUserRoleCondition;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UUserRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table u_user_role
     *
     * @mbg.generated
     */
    long countByExample(UUserRoleCondition example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table u_user_role
     *
     * @mbg.generated
     */
    int deleteByExample(UUserRoleCondition example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table u_user_role
     *
     * @mbg.generated
     */
    int insert(UUserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table u_user_role
     *
     * @mbg.generated
     */
    int insertSelective(UUserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table u_user_role
     *
     * @mbg.generated
     */
    List<UUserRole> selectByExample(UUserRoleCondition example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table u_user_role
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") UUserRole record, @Param("example") UUserRoleCondition example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table u_user_role
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") UUserRole record, @Param("example") UUserRoleCondition example);
}