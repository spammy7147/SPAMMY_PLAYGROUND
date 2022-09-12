package com.seven.jong.service.security.autologin;

import com.seven.jong.VO.security.UserSecurityVO;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.util.Assert;

public class UserStatusChecker implements MessageSourceAware {

    protected MessageSourceAccessor messages = SpringSecurityMessageSource.getAccessor();

    public UserStatusChecker() {
    }
    public void check(UserSecurityVO user) {
        if(user.getUser().getIsAccountLocked()) {
            throw new LockedException(this.messages.getMessage("User Account Locked", "잠긴 유저 계정입니다."));
        }
    }

    public void setMessageSource(MessageSource messageSource) {
        Assert.notNull(messageSource, "messageSource cannot be null");
        this.messages = new MessageSourceAccessor(messageSource);
    }
}

