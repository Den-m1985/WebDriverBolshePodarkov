package org.example.window.helper_classes;

import org.example.authentication.LoginStorage;

public class Authorization {

    public Authorization() throws Exception {

        String[] authorizationData = new LoginPasswordDialog().enterLoginPassword();

        String login = authorizationData[0];
        String password = authorizationData[1];

        LoginStorage loginStorage = new LoginStorage();
        loginStorage.saveToFile(login, password);
    }

}
