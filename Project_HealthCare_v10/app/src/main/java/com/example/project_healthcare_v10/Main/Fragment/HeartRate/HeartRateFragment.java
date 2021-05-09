package com.example.project_healthcare_v10.Main.Fragment.HeartRate;

import com.example.project_healthcare_v10.Main.Fragment.BaseItemFragment;
import com.example.project_healthcare_v10.R;

public class HeartRateFragment extends BaseItemFragment {

    @Override
    protected void onCreateViewAppend() {
        setInputItem("Heart Rate:","BPM",0, R.drawable.heart_rate);
        setInputItem("Heart Pressure:","mmHg",1, R.drawable.pressure);

        initChart(0);
        initChart(1);

        lineCharts[0].setData(presenter.formatDataToLineChart("Heart Rate", 0, R.color.red));
        lineCharts[0].getDescription().setText("BPM");
        lineCharts[1].setData(presenter.formatDataToLineChart("Heart Pressure", 1,R.color.teal_200));
        lineCharts[1].getDescription().setText("mmHg");
    }

    @Override
    protected void initPresenter() {
        presenter = new HeartBeatPresenter();
        presenter.setView(this);
        presenter.getData(rccVwData,0);
    }

}
