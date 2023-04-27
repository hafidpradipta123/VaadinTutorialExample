package com.example.application.it;

import com.vaadin.flow.component.login.testbench.LoginFormElement;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class LoginIT extends LoginE2ETest{


    @Test
    public void loginAsValidUserSucceeds(){
        LoginFormElement form = $(LoginFormElement.class).first();

        form.getUsernameField().setValue("user");
        form.getUsernameField().setValue("userpass");
        form.getSubmitButton().click();

        assertFalse($(LoginFormElement.class).exists());


    }


}
