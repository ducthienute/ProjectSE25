package com.example.project_healthcare_v10.Login;

public interface LoginContract {
    interface View {
        void loginSuccess();

        void loginFailure(String error);
    }

    interface Presenter {
        void handleLogin(String username, String password);
    }
}
