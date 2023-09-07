package com.suresec.uias.authentication;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apereo.cas.authentication.RememberMeUsernamePasswordCredential;

/**
 * @author Wan CC
 * @create 2023-09-07 10:58
 * @Description: 自定义Credential，可以接收验证码
 */
public class UsernamePasswordCaptchaCredential extends RememberMeUsernamePasswordCredential
{

    private static final long serialVersionUID = -2362388928807415990L;

    /**
     * 验证码
     */
    private String captcha;

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(this.captcha)
                .toHashCode();
    }
}
