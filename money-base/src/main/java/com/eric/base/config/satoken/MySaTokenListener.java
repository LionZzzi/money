package com.eric.base.config.satoken;

import cn.dev33.satoken.listener.SaTokenListener;
import cn.dev33.satoken.stp.SaLoginModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Eric
 * @date 2021/5/2 22:34
 */
@Slf4j
@Component
public class MySaTokenListener implements SaTokenListener {

    /**
     * 每次登录时触发
     */
    @Override
    public void doLogin(String loginKey, Object loginId, SaLoginModel loginModel) {
        // ...
    }

    /**
     * 每次注销时触发
     */
    @Override
    public void doLogout(String loginKey, Object loginId, String tokenValue) {
        // ...
    }

    /**
     * 每次被踢下线时触发
     */
    @Override
    public void doLogoutByLoginId(String loginKey, Object loginId, String tokenValue, String device) {
        // ...
    }

    /**
     * 每次被顶下线时触发
     */
    @Override
    public void doReplaced(String loginKey, Object loginId, String tokenValue, String device) {
        // ...
    }

    /**
     * 每次被封禁时触发
     */
    @Override
    public void doDisable(String loginKey, Object loginId, long disableTime) {
        // ...
    }

    /**
     * 每次被解封时触发
     */
    @Override
    public void doUntieDisable(String loginKey, Object loginId) {
        // ...
    }

    /**
     * 每次创建Session时触发
     */
    @Override
    public void doCreateSession(String id) {
        // ...
    }

    /**
     * 每次注销Session时触发
     */
    @Override
    public void doLogoutSession(String id) {
        // ...
    }
}
