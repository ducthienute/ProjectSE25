package com.example.project_healthcare_v10.Main.Fragment.BodyInfo;

import android.app.AlertDialog;

import com.example.project_healthcare_v10.Main.Fragment.BaseItem;
import com.example.project_healthcare_v10.Main.Fragment.BaseItemAdapter;
import com.example.project_healthcare_v10.Main.Fragment.BaseItemPresenter;
import com.example.project_healthcare_v10.Main.Fragment.BodyInfo.BodyInfoItem;
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

public class BodyInfoPresenter extends BaseItemPresenter {
    @Override
    public void queryData() {
        LocalDatabase db = new LocalDatabase(view.getContext(),1);
        itemAdapter = new BaseItemAdapter(view.getContext(), db.getListData(LocalDatabase.Type.BODY), R.drawable.weight_scale, R.drawable.height_ruler);
    }

    @Override
    public String[] getType() {
        return new String[]{"BMI"};
    }

    @Override
    public String getEvaluate(int index, float y) {
        return BodyInfoItem.getEvaluate(y);
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
        if (data[0].toString().length() == 0 || data[1].toString().length() == 0)
            return false;
        return true;
    }

    @Override
    public LocalDatabase.Type getTableName() {
        return LocalDatabase.Type.BODY;
    }



    @Override
    public BaseItem newData(LocalDateTime dateTime, Object... data) {
        return new BodyInfoItem(Float.parseFloat(data[0].toString()), Float.parseFloat(data[1].toString()), dateTime);
    }

}
