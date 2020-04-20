package com.djz.self.modules.basic.domain.vo;

import com.djz.self.modules.basic.domain.User;

/**
 * @author djz
 * @createTime 2020-04-17
 */
public class UserVo extends User {
    private String TGT;

    public String getTGT() {
        return TGT;
    }

    public void setTGT(String TGT) {
        this.TGT = TGT;
    }
}
