package com.example.project_healthcare_v10.Login;

public class LoginPresenter implements LoginContract.Presenter {

    LoginContract.View view;

    public void setView(LoginContract.View view) {
        this.view = view;
    }

    @Override
    public void handleLogin(String username, String password) {
        if (username.equals("admin") && password.equals("123")) {
            view.loginSuccess();
        } else {
            view.loginFailure("Đăng nhập thất bại!");
        }
    }
}
