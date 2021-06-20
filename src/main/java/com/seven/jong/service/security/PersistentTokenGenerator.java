package com.seven.jong.service.security;

import com.seven.jong.VO.security.PersistentTokenVO;
import com.seven.jong.repository.IPersistentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersistentTokenGenerator implements PersistentTokenRepository {

    IPersistentMapper persistentMapper;

    @Autowired
    public void setPersistentMapper(IPersistentMapper persistentMapper) {
        this.persistentMapper = persistentMapper;
    }

    public void createNewToken(PersistentTokenVO persistentRememberMeToken) {
        persistentMapper.createNewToken(persistentRememberMeToken);
    }


    public void updateToken(PersistentTokenVO persistentRememberMeToken) {
        persistentMapper.updateToken(persistentRememberMeToken);
    }

    public PersistentTokenVO getTokenForKey(String key) {
        return persistentMapper.getTokenForKey(key);
    }

    public PersistentTokenVO getTokenByUserId(Integer userId) {
        return persistentMapper.getTokenByUserId(userId);
    }

    public void removeUserTokens(Integer userId) {
        persistentMapper.removeUserTokens(userId);
    }

    @Override
    public void createNewToken(PersistentRememberMeToken persistentRememberMeToken) {

    }

    @Override
    public void updateToken(String s, String s1, Date date) {

    }

    @Override
    public PersistentRememberMeToken getTokenForSeries(String s) {
        return null;
    }


    @Override
    public void removeUserTokens(String s) {

    }
}


