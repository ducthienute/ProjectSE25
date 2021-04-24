package com.example.project_healthcare_v10.Main.Fragment;

public abstract class BaseItemPresenter implements BaseItemContract.Presenter {
    public BaseItemContract.View view;

    public void setView(BaseItemContract.View view) {
        this.view = view;
    }
}
