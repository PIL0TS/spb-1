package com.tream.common.auth.validator.dto;

/**
 * 验证凭据
 */
public interface Credence {

    /**
     * 凭据名称
     * @return
     */
    String getCredenceName();

    /**
     * 密码或者其他验证码
     * @return
     */
    String getCredenceCode();


}
