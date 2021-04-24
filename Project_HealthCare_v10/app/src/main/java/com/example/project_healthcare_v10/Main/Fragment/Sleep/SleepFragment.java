package com.example.project_healthcare_v10.Main.Fragment.Sleep;

import com.example.project_healthcare_v10.Main.Fragment.BaseItemFragment;
import com.example.project_healthcare_v10.R;

public class SleepFragment extends BaseItemFragment {

    @Override
    protected void onCreateViewAppend() {
        setItem("Start: ","time",0, R.drawable.sleeping);
        setItem("End: ","time",1, R.drawable.wake_up);
    }


    @Override
    protected void initPresenter() {

    }

}
