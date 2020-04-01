package com.djz.self.security.cas;

import com.djz.self.modules.basic.domain.User;
import org.apache.shiro.authc.RememberMeAuthenticationToken;
import org.apache.shiro.cas.CasToken;

public class MyCasToken implements RememberMeAuthenticationToken {

    private static final long serialVersionUID = 8587329689973009598L;

    // the service ticket returned by the CAS server
    private String ticket = null;

    // the user identifier
    private String userId = null;

    // is the user in a remember me mode ?
    private boolean isRememberMe = false;

    private User user;

    public MyCasToken(String ticket) {
        this.ticket = ticket;
    }

    public MyCasToken(User user) {
        this.user = user;
    }

    public MyCasToken(User user,String ticket) {
        this.user = user;
        this.ticket = ticket;
    }
    public Object getPrincipal() {
        return userId;
    }

    public Object getCredentials() {
        return ticket;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean isRememberMe() {
        return isRememberMe;
    }

    public void setRememberMe(boolean isRememberMe) {
        this.isRememberMe = isRememberMe;
    }

}
