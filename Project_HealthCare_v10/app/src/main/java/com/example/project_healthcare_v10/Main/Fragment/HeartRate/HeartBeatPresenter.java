package com.example.project_healthcare_v10.Main.Fragment.HeartRate;

import com.example.project_healthcare_v10.Main.Fragment.BaseItem;
import com.example.project_healthcare_v10.Main.Fragment.BaseItemAdapter;
import com.example.project_healthcare_v10.Main.Fragment.BaseItemPresenter;
import com.example.project_healthcare_v10.R;
import com.github.mikephil.charting.data.LineData;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

public class HeartBeatPresenter extends BaseItemPresenter {
    @Override
    public void queryData() {
        ArrayList<BaseItem> dataTest = new ArrayList<>();
        int i = 0;
        dataTest.add(newData(i * 10,i++ * -7, LocalDateTime.of(2020,1,15,12,12,12)));
        dataTest.add(newData(i * 10,i++ * 7, LocalDateTime.of(2020,2,15,12,12,12)));
        dataTest.add(newData(i * 10,i++ * -7, LocalDateTime.of(2020,3,15,12,12,12)));
        dataTest.add(newData(i * 10,i++ * 7, LocalDateTime.of(2020,4,15,12,12,12)));
        dataTest.add(newData(i * 10,i++ * -7, LocalDateTime.of(2020,5,15,12,12,12)));
        dataTest.add(newData(i * 10,i++ * 7, LocalDateTime.of(2020,6,15,12,12,12)));
        dataTest.add(newData(i * 10,i++ * -7, LocalDateTime.of(2020,7,15,12,12,12)));
        dataTest.add(newData(i * 10,i++ * 7, LocalDateTime.of(2020,8,15,12,12,12)));
        dataTest.add(newData(i * 10,i * -7, LocalDateTime.of(2020,9,15,12,12,12)));

        itemAdapter = new BaseItemAdapter(view.getContext(), dataTest, R.drawable.heart_rate, R.drawable.pressure);
    }

    @Override
    public void Evaluate() {
        view.showMessage("Evaluate");
    }

    @Override
    public void EvaluateAll() {

    }

    @Override
    public boolean isDataValid(Object... data) {
        return true;
    }

    @Override
    public BaseItem newData(Object... data) {
        return new HeartRateItem(data[0],data[1], data.length == 2 ? LocalDateTime.now(): (LocalDateTime) data[2]);
    }
}
