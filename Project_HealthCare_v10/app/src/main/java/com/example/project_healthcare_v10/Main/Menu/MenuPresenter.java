package com.example.project_healthcare_v10.Main.Menu;

public class MenuPresenter implements MenuContract.Presenter {
    MenuContract.View view;

    public void setView(MenuContract.View view) {
        this.view = view;
    }

}
