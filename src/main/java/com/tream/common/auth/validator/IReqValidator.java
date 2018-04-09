package com.tream.common.auth.validator;

import com.tream.common.auth.validator.dto.Credence;

/**
 * 验证请求 auth 接口时，请求数据的正确性
 */
public interface IReqValidator {

    /**
     * 通过请求验证参数
     */
    boolean validate(Credence credence);




}
