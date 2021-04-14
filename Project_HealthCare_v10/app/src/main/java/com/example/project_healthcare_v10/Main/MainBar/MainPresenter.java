package com.example.project_healthcare_v10.Main.MainBar;

public class MainPresenter implements MainContract.Presenter {
    private MainContract.View view;

    public void setView(MainContract.View view) {
        this.view = view;
    }
}
