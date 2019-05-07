package com.cy.demo.dto.power;

/**
 * Created by zhoudachao on 2019/4/25.
 */
public class ModifyPassword {
    private String newPassword;

    private String checkPassword;

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getCheckPassword() {
        return checkPassword;
    }

    public void setCheckPassword(String checkPassword) {
        this.checkPassword = checkPassword;
    }
}
