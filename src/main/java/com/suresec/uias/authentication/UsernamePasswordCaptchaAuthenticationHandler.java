package com.suresec.uias.authentication;

import com.suresec.uias.authentication.exception.CaptchaException;
import com.suresec.uias.service.UserService;
import com.suresec.uias.vo.UserInfo;
import org.apereo.cas.authentication.AuthenticationHandlerExecutionResult;
import org.apereo.cas.authentication.Credential;
import org.apereo.cas.authentication.MessageDescriptor;
import org.apereo.cas.authentication.PreventedException;
import org.apereo.cas.authentication.handler.PrincipalNameTransformer;
import org.apereo.cas.authentication.handler.support.AbstractPreAndPostProcessingAuthenticationHandler;
import org.apereo.cas.authentication.principal.PrincipalFactory;
import org.apereo.cas.services.ServicesManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.security.auth.login.AccountNotFoundException;
import javax.security.auth.login.FailedLoginException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Wan CC
 * @create 2023-09-07 10:53
 * @Description:自定义Handler 复写验证逻辑
 */
public class UsernamePasswordCaptchaAuthenticationHandler extends AbstractPreAndPostProcessingAuthenticationHandler
{
    private static final Logger LOGGER = LoggerFactory.getLogger(UsernamePasswordCaptchaAuthenticationHandler.class);

    private UserService userService;
    public UsernamePasswordCaptchaAuthenticationHandler(String name, ServicesManager servicesManager,
            PrincipalFactory principalFactory, Integer order, UserService userService) {
        super(name, servicesManager, principalFactory, order);
        this.userService = userService;
        // TODO Auto-generated constructor stub
    }


    private PasswordEncoder passwordEncoder = NoOpPasswordEncoder.getInstance();
    private PrincipalNameTransformer principalNameTransformer = (formUserId) -> {
        return formUserId;
    };

    // 判断是否支持自定义用户登入凭证
    @Override
    public boolean supports(Credential credential) {
        // TODO Auto-generated method stub
//        LOGGER.error("credential instanceof UsernamePasswordCaptchaCredential===" + (credential instanceof UsernamePasswordCaptchaCredential));
        return credential instanceof UsernamePasswordCaptchaCredential;
    }

    @Override
    protected AuthenticationHandlerExecutionResult doAuthentication(Credential credential) throws GeneralSecurityException, PreventedException
    {
        // TODO Auto-generated method stub
        // 用户凭证
        UsernamePasswordCaptchaCredential myCredential = (UsernamePasswordCaptchaCredential) credential;
        String requestCaptcha = myCredential.getCaptcha();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        Object attribute = attributes.getRequest().getSession().getAttribute("captcha");

        String realCaptcha = attribute == null ? null : attribute.toString();
        LOGGER.error("realCaptcha=====" + realCaptcha + "||" + "requestCaptcha=====" + requestCaptcha);
        LOGGER.error("requestCaptcha.equals(realCaptcha)=====" + requestCaptcha.equals(realCaptcha));
        LOGGER.error("org.apache.commons.lang3.StringUtils.isEmpty(requestCaptcha)=====" + org.apache.commons.lang3.StringUtils.isEmpty(requestCaptcha));
        if(org.apache.commons.lang3.StringUtils.isEmpty(requestCaptcha) || !realCaptcha.equalsIgnoreCase(requestCaptcha)){
            LOGGER.error("请输入正确的验证码" + "requestCaptcha.equals(realCaptcha)=====" + requestCaptcha.equalsIgnoreCase(realCaptcha));
            throw new CaptchaException();
        }else{
            LOGGER.error("requestCaptcha.equals(realCaptcha)=====" + requestCaptcha.equals(realCaptcha));
            if(org.apache.commons.lang3.StringUtils.isBlank(myCredential.getUsername())){
                throw new AccountNotFoundException("Username is null.");
            }else{
                LOGGER.error("Transforming credential username via [{}]", this.principalNameTransformer.getClass().getName());
                String transformedUsername = this.principalNameTransformer.transform(myCredential.getUsername());
                if(org.apache.commons.lang3.StringUtils.isBlank(transformedUsername)){
                    throw new AccountNotFoundException("Transformed username is null.");
                }else if(org.apache.commons.lang3.StringUtils.isBlank(myCredential.getPassword())){
                    throw new FailedLoginException("Password is null.");
                }else{
                    LOGGER.error("Attempting to encode credential password via [{}] for [{}]", this.passwordEncoder.getClass().getName(), transformedUsername);
                    String transformedPsw = this.passwordEncoder.encode(myCredential.getPassword());
                    if(org.apache.commons.lang3.StringUtils.isBlank(transformedPsw)){
                        throw new AccountNotFoundException("Encoded password is null.");
                    }else{
                        // TODO-WCC: 增加校验：账号密码；证书验签；手机扫码登录   [WanCC 2023/9/13  11:06]
                        UserInfo u = userService.selectByLoginName(myCredential.getUsername());
                        myCredential.setUsername(transformedUsername);
                        myCredential.setPassword(transformedPsw);
                        //map 为返回给客户端的信息
                        Map<String, Object> map = new HashMap<>();
                        if(u!=null){
                            map.put("loginName", u.getLoginName());
                            map.put("username", u.getUserName());
                        }
                        List<MessageDescriptor> warning = new ArrayList<MessageDescriptor>();
                        LOGGER.error("Attempting authentication internally for transformed credential [{}]", myCredential);
                        return createHandlerResult(myCredential, principalFactory.createPrincipal(myCredential.getUsername(), map), warning);
                    }
                }
            }
        }
    }

}
