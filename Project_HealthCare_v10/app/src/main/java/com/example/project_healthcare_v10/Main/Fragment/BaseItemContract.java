package com.example.project_healthcare_v10.Main.Fragment;

public interface BaseItemContract {
    interface View {
        void setItem(String str, String hint, int indexItem, int drawable_id);
        void showMessage(String mess);
    }
    interface Presenter {
        void Add();
        void Edit();
        void Delete();
        void Evaluate();
        void Sync();
        void Graph();
    }
}
