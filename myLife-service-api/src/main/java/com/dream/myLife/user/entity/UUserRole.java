package com.dream.myLife.user.entity;

import java.io.Serializable;

public class UUserRole implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column u_user_role.uid
     *
     * @mbg.generated
     */
    private Long uid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column u_user_role.rid
     *
     * @mbg.generated
     */
    private Long rid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table u_user_role
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column u_user_role.uid
     *
     * @return the value of u_user_role.uid
     *
     * @mbg.generated
     */
    public Long getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column u_user_role.uid
     *
     * @param uid the value for u_user_role.uid
     *
     * @mbg.generated
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column u_user_role.rid
     *
     * @return the value of u_user_role.rid
     *
     * @mbg.generated
     */
    public Long getRid() {
        return rid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column u_user_role.rid
     *
     * @param rid the value for u_user_role.rid
     *
     * @mbg.generated
     */
    public void setRid(Long rid) {
        this.rid = rid;
    }
}