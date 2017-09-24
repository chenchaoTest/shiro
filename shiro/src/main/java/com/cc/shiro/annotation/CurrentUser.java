package com.cc.shiro.annotation;


import java.lang.annotation.*;

import com.cc.shiro.constants.Constants;

/**
 * <p>�󶨵�ǰ��¼���û�</p>
 * <p>��ͬ��@ModelAttribute</p>
 *
 * @author Zhang Kaitao
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrentUser {

    /**
     * ��ǰ�û���request�е�����
     *
     * @return
     */
    String value() default Constants.CURRENT_USER;

}