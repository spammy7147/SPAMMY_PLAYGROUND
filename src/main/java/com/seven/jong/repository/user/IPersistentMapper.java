package com.seven.jong.repository.user;

import com.seven.jong.VO.security.PersistentTokenVO;

public interface IPersistentMapper {

    void createNewToken(PersistentTokenVO persistentRememberMeToken);

    void updateToken(PersistentTokenVO persistentRememberMeToken);

    PersistentTokenVO getTokenForKey(String key);

    PersistentTokenVO getTokenByUserId(Integer userId);

    void removeUserTokens(Integer userId);
}
