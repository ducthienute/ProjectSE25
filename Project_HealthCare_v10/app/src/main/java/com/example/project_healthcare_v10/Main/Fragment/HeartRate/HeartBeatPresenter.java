package com.example.project_healthcare_v10.Main.Fragment.HeartRate;

import com.example.project_healthcare_v10.Main.Fragment.BaseItemPresenter;

public class HeartBeatPresenter extends BaseItemPresenter {
    @Override
    public void Add() {
        view.showMessage("Add");
    }

    @Override
    public void Edit() {
        view.showMessage("Edit");
    }

    @Override
    public void Delete() {
        view.showMessage("Delete");
    }

    @Override
    public void Evaluate() {
        view.showMessage("Evaluate");
    }

    @Override
    public void Sync() {
        view.showMessage("Sync");
    }

    @Override
    public void Graph() {
        view.showMessage("Graph");
    }
}
