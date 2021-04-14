package com.example.project_healthcare_v10.Main.Fragment.HeartRate;

import com.example.project_healthcare_v10.Main.Fragment.BaseItemFragment;
import com.example.project_healthcare_v10.R;

public class HeartRateFragment extends BaseItemFragment {

    @Override
    protected void onCreateViewAppend() {
        setItem("Heart Rate:","BPM",0, R.drawable.heart_rate);
        setItem("Heart Pressure:","mmHg",1, R.drawable.pressure);
    }

    @Override
    protected void initAction() {

    }

    @Override
    protected void initPresenter() {

    }

}
