package com.example.project_healthcare_v10.Main.Fragment.Heart;

import android.app.AlertDialog;

import com.example.project_healthcare_v10.Main.Fragment.BaseItem;
import com.example.project_healthcare_v10.Main.Fragment.BaseItemAdapter;
import com.example.project_healthcare_v10.Main.Fragment.BaseItemPresenter;
import com.example.project_healthcare_v10.Model.Database.LocalDatabase;
import com.example.project_healthcare_v10.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.LineDataSet;

import org.apache.commons.math3.stat.regression.SimpleRegression;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

public class HeartPresenter extends BaseItemPresenter {
    @Override
    public void queryData() {
        LocalDatabase db = new LocalDatabase(view.getContext(),1);
        itemAdapter = new BaseItemAdapter(view.getContext(), db.getListData(LocalDatabase.Type.HEART), R.drawable.heart_rate, R.drawable.pressure);
    }

    @Override
    public String[] getType() {
        return new String[]{"Nhịp Tim", "Huyết Áp"};
    }

    @Override
    public String getEvaluate(int index, float y) {
        if(index == 0)
            return newData(LocalDateTime.now(),y,0).getStatus().getEvaluate();
        return newData(LocalDateTime.now(),0,y).getStatus().getEvaluate();
    }

    @Override
    public float getDataDoubt() {
        return 0.7f;
    }

    @Override
    public boolean isDataValid(Object... data) {
        return true;
    }

    @Override
    public boolean isInputValid(Object... data) {
        return data[0].toString().length() != 0 && data[1].toString().length() != 0;
    }

    @Override
    public LocalDatabase.Type getTableName() {
        return LocalDatabase.Type.HEART;
    }



    @Override
    public BaseItem newData(LocalDateTime dateTime, Object... data) {
        return new HeartItem(data[0], data[1], dateTime);
    }
}
