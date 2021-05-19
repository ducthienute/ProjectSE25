package com.example.project_healthcare_v10.Main.Fragment.Heart;

import android.view.View;

import com.example.project_healthcare_v10.Main.Fragment.BaseItemFragment;
import com.example.project_healthcare_v10.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.LineData;

import org.apache.commons.math3.geometry.euclidean.twod.Line;

public class HeartFragment extends BaseItemFragment {

    @Override
    protected void onCreateViewAppend() {
        setInputItem("Heart Rate:","BPM",0, R.drawable.heart_rate);
        setInputItem("Heart Pressure:","mmHg",1, R.drawable.pressure);
    }

    @Override
    protected void initPresenter() {
        presenter = new HeartPresenter();
        presenter.setView(this);
        presenter.getData(rccVwData);
    }

    @Override
    public void initChart() {
        int[] color = {R.color.red,R.color.purple_700};
        Description[] descriptions = {presenter.newDescription("BPM"),presenter.newDescription("mmHg")};
        for(int i =0 ;i<2;i++) {
            lineCharts[i].setVisibility(View.VISIBLE);
            LineData lineData = new LineData();
            lineData.addDataSet(presenter.getDataLineDataSet(presenter.getType()[i], i, color[i]));
            lineData.addDataSet(presenter.getRegressionLineDataSet("Tổng Thể", i, 1, R.color.teal_200));
            lineData.addDataSet(presenter.getRegressionLineDataSet("Gần Đây", i, 0.25f, R.color.teal_700));
            lineCharts[i].setData(lineData);
            lineCharts[i].setDescription(descriptions[i]);
        }

    }
}
