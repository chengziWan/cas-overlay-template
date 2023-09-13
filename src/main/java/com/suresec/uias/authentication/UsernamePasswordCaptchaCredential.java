package com.suresec.uias.authentication;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apereo.cas.authentication.UsernamePasswordCredential;

/**
 * @author Wan CC
 * @create 2023-09-07 10:58
 * @Description: 自定义Credential，可以接收验证码
 */

public class UsernamePasswordCaptchaCredential extends UsernamePasswordCredential
{

    private static final long serialVersionUID = -2362388928807415990L;

    /**
     * 验证码
     */
    private String captcha;//验证码
    private String submitMode; //登录方式
    private String signvalue; //签名值
    private String CertDN; //DN
    private String sInData; //随机字符串
    private String cert_flag; //证书标识
    // ADD-WCC: 扫码登录添加   [WanCC 2023/7/19  14:06]
    private String authCode; //authCode--不一定能用上
    private String userPhone; //手机号

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public String getSubmitMode()
    {
        return submitMode;
    }

    public void setSubmitMode(String submitMode)
    {
        this.submitMode = submitMode;
    }

    public String getSignvalue()
    {
        return signvalue;
    }

    public void setSignvalue(String signvalue)
    {
        this.signvalue = signvalue;
    }

    public String getCertDN()
    {
        return CertDN;
    }

    public void setCertDN(String certDN)
    {
        CertDN = certDN;
    }

    public String getsInData()
    {
        return sInData;
    }

    public void setsInData(String sInData)
    {
        this.sInData = sInData;
    }

    public String getCert_flag()
    {
        return cert_flag;
    }

    public void setCert_flag(String cert_flag)
    {
        this.cert_flag = cert_flag;
    }

    public String getAuthCode()
    {
        return authCode;
    }

    public void setAuthCode(String authCode)
    {
        this.authCode = authCode;
    }

    public String getUserPhone()
    {
        return userPhone;
    }

    public void setUserPhone(String userPhone)
    {
        this.userPhone = userPhone;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(this.captcha)
                .toHashCode();
    }
}
